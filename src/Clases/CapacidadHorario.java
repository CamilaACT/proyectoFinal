package Clases;

import java.util.Arrays;

public class CapacidadHorario {
    private boolean[][] horarioDisponible;

    public CapacidadHorario(int mes) {
        if(mes==1||mes==12||mes==3||mes==5||mes==7||mes==8||mes==10){
            horarioDisponible = new boolean[31][24];
            for (int i = 0; i < 31; i++) {
                Arrays.fill(horarioDisponible[i], true);
            }
        }
        if(mes==4||mes==6||mes==9||mes==11){
            horarioDisponible = new boolean[31][24];
            for (int i = 0; i < 30; i++) {
                Arrays.fill(horarioDisponible[i], true);
            }
        }
        if(mes==2){
            horarioDisponible = new boolean[31][24];
            for (int i = 0; i < 29; i++) {
                Arrays.fill(horarioDisponible[i], true);
            }
        }
    }

    public boolean reservarHora(int diaSemana, int hora) {
        if (diaSemana >= 0 && diaSemana < 31 && hora >= 0 && hora < 24 && horarioDisponible[diaSemana][hora]) {
            horarioDisponible[diaSemana][hora] = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean liberarHora(int diaSemana, int hora) {
        if (diaSemana >= 0 && diaSemana < 7 && hora >= 0 && hora < 24 && !horarioDisponible[diaSemana][hora]) {
            horarioDisponible[diaSemana][hora] = true;
            return true;
        } else {
            return false;
        }
    }

}

