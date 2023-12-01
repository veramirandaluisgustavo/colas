package com.SERVER_CONTROLLER.CONTROLLER.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.SERVER_CONTROLLER.CONTROLLER.model.Medico;
import com.SERVER_CONTROLLER.CONTROLLER.model.Paciente;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ChatHandler extends TextWebSocketHandler {

    private final CopyOnWriteArrayList<WebSocketSession> pantallas = new CopyOnWriteArrayList<WebSocketSession>();
    private final CopyOnWriteArrayList<Paciente> pacientes = new CopyOnWriteArrayList<Paciente>();
    private final CopyOnWriteArrayList<Medico> medicos = new CopyOnWriteArrayList<Medico>();
    private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>();
    // private static final HashMap<Integer,WebSocketSession> map=new HashMap<>();
    // private static final HashMap<WebSocketSession,Integer> map2=new HashMap<>();
    // private static final HashMap<Paciente,WebSocketSession> pacientes1=new
    // HashMap<>();
    // private static final HashMap<WebSocketSession,Paciente> pacientes2=new
    // HashMap<>();
    private static final HashMap<Medico, WebSocketSession> medicos1 = new HashMap<>();
    private static final HashMap<WebSocketSession, Medico> medicos2 = new HashMap<>();
    private int n_cliente = 1;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        // map.put(n_cliente,session);
        // map2.put(session,n_cliente);
        // System.out.println("SE CREO LA SECION NUMERO:"+n_cliente);
        // session.sendMessage(new TextMessage("hola"));
        // session.sendMessage(new TextMessage("paciente:"+n_cliente));
        // n_cliente++;

    }

    private String obtenerIp() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (addr.isSiteLocalAddress() && !addr.isLoopbackAddress()) {
                        System.out.println("SE ENVIO LA IP " + addr.getHostAddress());
                        return addr.getHostAddress();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("NO SE PUDO");
        }
        return "";
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        if (!eliminarSecion(session, medicos2, medicos1)) {
            try {
                pantallas.remove(session);

            } catch (Exception e) {
                sessions.remove(session);

            }

        }

        System.out.println("SE ELIMINO UN CLIENTE");

        // sessions.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String men = message.getPayload();
        System.out.println(men);
        String data[] = men.split("-");
        System.out.println(men);
        switch (data[0]) {
            case "pantalla":
                pantallas.add(session);
                sessions.remove(session);
                System.out.println("SE AGREGO UNA PANTALLA CORRECTAMENTE");
                break;

            case "medico":
                try {
                    Medico med = new Medico();
                    med.setNombre(data[1].split(":")[1]);
                    med.setConsultorio(data[2].split(":")[1]);
                    med.setEspecialidad(data[3].split(":")[1]);
                    System.out.println("LA ESPECIALIDAD DEL MEDICO ES:"+med.getEspecialidad());
                    medicos2.put(session, med);
                    medicos1.put(med, session);
                    sessions.remove(session);
                    medicos.add(med);
                    System.out.println("SE AGREGO UN MEDICO CORRECTAMENTE");
                    pacientelista(session);
                    break;
                } catch (Exception e) {
                    System.out.println("error al agregar un medico");
                    break;
                }
            case "paciente":
                try {
                    Paciente pac = new Paciente();
                    pac.setNombre(data[1].split(":")[1]);
                    pac.setCi(data[2].split(":")[1]);
                    pac.setId(n_cliente);
                    pac.setMedico(data[3].split(":")[1]);
                    pac.setEspecialidad(data[4].split(":")[1]);
                    System.out.println("LA ESPECIALIDAD DEL PACIENTE ES:"+pac.getEspecialidad());
                    pacientes.add(pac);
                    // pacientes1.put(pac, session);
                    session.sendMessage(new TextMessage(String.valueOf(n_cliente)));
                    sessions.remove(session);
                    System.out.println("SE AGREGO UN PACIENTE CORRECTAMENTE");
                    //System.out.println("SE GUARDO EL MEDICO: " + pac.getMedico());
                    n_cliente++;
                    for(Medico med:medicos){
                        if(med.getNombre().equals(pac.getMedico()) && med.getEstado().equals("libre")){
                            pacientelista(medicos1.get(med));
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("error al agregar un paciente");
                    break;
                }
            case "siguiente":
                pacientelista(session);
                break;

            default:
                System.out.println("MESAGE RECIVIDO NO CUMPLE EL FORMATO");
                break;
        }

        // for (WebSocketSession webSocketSession : sessions){
        // webSocketSession.sendMessage(message);
        // }
    }
    // public static WebSocketSession getSesion(String men){
    // WebSocketSession respuesta=null;
    // try {
    // System.out.println(men);
    // String data[]=men.split(":");

    // if(map.containsKey(Integer.parseInt(data[0]))){
    // respuesta= map.get(Integer.parseInt(data[0]));
    // return respuesta;

    // }

    // } catch (Exception e) {
    // System.out.println("CODIGO INTRODUZIDO NO VALIDO");
    // return respuesta;
    // }

    // return null;

    // }
    private Boolean eliminarSecion(WebSocketSession secion, HashMap mapa, HashMap mapa2) {

        if (mapa.containsKey(secion)) {
            try {
                medicos.remove(mapa.get(secion));
            } catch (Exception e) {
                // TODO: handle exception
            }
            mapa2.remove(mapa.get(secion));
            mapa.remove(secion);
            
            return true;
        }
        return false;

    }

    private void pacientelista(WebSocketSession medico) {
        Medico med = medicos2.get(medico);
        System.out.println("SE ENTRO AQUI");
        System.out.println("el nombre del medico solicitante es: " + med.getNombre());
        // System.out.println("NOMBRES A COMPARAR: "+med.getNombre()+" Y "+);
        Medico medi;
        System.out.println("LA CANTIDAD DE PACIENTE ES: " + pacientes.size());
        for (Paciente pac : pacientes) {
            System.out.println("NOMBRES A COMPARAR: " + med.getNombre() + " Y " + pac.getMedico());
            String tenp1=med.getNombre().toString();
            String tenp2=pac.getMedico().toString();
            
            
            if (tenp1.equals(tenp2) ||(med.getEspecialidad().equals(pac.getEspecialidad()) && pac.getMedico().equals("nulo"))) {
                System.out.println("LOG DOCTOR" + pac.getMedico());
                try {
                    medico.sendMessage(new TextMessage(
                            "paciente-nombre:" + pac.getNombre() + "-ci:" + pac.getCi() + "-id:" + pac.getId()));
                            med.setEstado("ocupado");
                            System.out.println("SE ENVIO UN PACIENTE AL DOCTOR :" + pac.getMedico());
                    for(WebSocketSession sec:pantallas){
                        sec.sendMessage(new TextMessage(
                            "paciente-nombre:" + pac.getNombre() + "-ci:" + pac.getCi() + "-id:" + pac.getId()+"-consultorio:"+med.getConsultorio()));
                    }
                    pacientes.remove(pac);
                } catch (IOException e) {
                    System.out.println("error al enviar cliente al medico");
                }
                return;
            }
            

        }
        try {
            medico.sendMessage(new TextMessage("NO HAY MAS PACIENTES"));
            medicos2.get(medico).setEstado("libre");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;
    }
    
    

}
