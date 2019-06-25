package Salary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class a {
    private JPanel Main;
    private JPanel Brut;
    private JPanel Net;
    private JPanel Salariu;
    private JPanel Sarbatori;
    private JPanel Weekend;
    private JPanel CM;
    private JPanel OT;
    private JPanel Saptamana;
    private JPanel Input;
    private JPanel Output;
    private JPanel Pensie;
    private JPanel Rest;
    private JPanel Bonuri;
    private JPanel baniOT;
    private JTextField brut;
    private JTextField net;
    private JTextField zileCM;
    private JTextField procentCM;
    private JTextField oreSaptamana;
    private JTextField oreWeekend;
    private JTextField oreSarbatori;
    private JTextField procentWeek;
    private JTextField procentHoliday;
    private JTextField procentWeekEnd;
    private JTextField pilon1;
    private JTextField pilon2;
    private JTextField CASS;
    private JTextField Impozit;
    private JTextField nrBon;
    private JTextField valBon;
    private JTextField venitOT;
    private JCheckBox scutiri;
    private JCheckBox liberOT;
//    private JButton netButton;
    private JButton brutButton;

    private String sNet;
//    private String sBrut;

    private String numarBon;
    private String valoareBon;

    private String CMzile;
    private String cmProcent;

    private String OTSapt;
    private String procentSapt;
    private String OTSarbatori;
    private String procentSarbatori;
    private String OTWeekend;
    private String procentWeekend;

    private boolean faraScutiri = true;
    private boolean ziLibera = false;

    public a() {
        brut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        net.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {

            }
        });

        nrBon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        valBon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        pilon1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        pilon2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        CASS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Impozit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        scutiri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (scutiri.isSelected()) {
                    faraScutiri = false;
                } else {
                    faraScutiri = true;
                }
            }
        });
        oreSaptamana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        oreSarbatori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        oreWeekend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        liberOT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (liberOT.isSelected()) {
                    ziLibera = true;
                } else {
                    ziLibera = false;
                }
            }
        });

//        netButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (netButton.isEnabled()) {
//                    sBrut = brut.getText();
//                    double salariuBrut = 0;
//                    if (!sBrut.isEmpty()) {
//                        salariuBrut = Double.valueOf(sBrut);
//                    }
//                    double brutFix = salariuBrut;
//
//
//                    //TODO: Valoarea in caz ca userul pune "," la zecimala
//                    valoareBon = valBon.getText();
//                    String[] z = valoareBon.split("");
//                    for (int i = 0; i < z.length; i++) {
//                        if (z[i].equals(",")) {
//                            z[i] = ".";
//                        }
//                    }
//                    StringBuilder x = new StringBuilder();
//                    for (int i = 0; i < z.length; i++) {
//                        x.append(z[i]);
//                    }
//                    valoareBon = x.toString();
//
//                    //TODO: Calcul valoare totala a bonurilor
//                    numarBon = nrBon.getText();
//                    double nrBonuri = 0;
//                    if (!numarBon.isEmpty()) {
//                        nrBonuri = Double.valueOf(numarBon);
//                    }
//                    double valBonuri = 0;
//                    if (!valoareBon.isEmpty()) {
//                        valBonuri = Double.valueOf(valoareBon);
//                    }
//                    double bonuri = nrBonuri * valBonuri;
//
//                    //TODO: Calcul ore overtime
//                    OTSapt = oreSaptamana.getText();
//                    double oreSapt = 0;
//                    if (!OTSapt.isEmpty()) {
//                        oreSapt = Double.valueOf(OTSapt);
//                    }
//                    procentSapt = procentWeek.getText();
//                    double saptProcent = Double.valueOf(procentSapt) / 100;
//
//
//                    OTSarbatori = oreSarbatori.getText();
//                    double oreSarb = 0;
//                    if (!OTSarbatori.isEmpty()) {
//                        oreSarb = Double.valueOf(OTSarbatori);
//                    }
//                    procentSarbatori = procentHoliday.getText();
//                    double sarbProcent = Double.valueOf(procentSarbatori) / 100;
//                    if (ziLibera) {
//                        sarbProcent = sarbProcent - 1;
//                    }
//
//
//                    OTWeekend = oreWeekend.getText();
//                    double OreWeekend = 0;
//                    if (!OTWeekend.isEmpty()) {
//                        OreWeekend = Double.valueOf(OTWeekend);
//                    }
//                    procentWeekend = procentWeekEnd.getText();
//                    double weekendProcent = Double.valueOf(procentWeekend) / 100;
//                    if (ziLibera) {
//                        weekendProcent = weekendProcent - 1;
//                    }
//
//                    //TODO: Verificare deduceri personale
//                    double brutTotal = salariuBrut + bonuri;
//                    double deductibil = getDeductibil(brutTotal);
//
//                    //TODO: Calcul estimativ CM
//                    CMzile = zileCM.getText();
//                    double cmZile = 0;
//                    if (!CMzile.isEmpty()) {
//                        cmZile = Double.valueOf(CMzile);
//                    }
//                    cmProcent = procentCM.getText();
//                    double CMporcent = 1 - Double.valueOf(cmProcent) / 100;
//                    double brutZi = brutFix / 21;
//                    salariuBrut = salariuBrut - (brutZi * CMporcent * cmZile);
//
//                    //TODO: Calcule salariu net
//                    int pUnu = (int) Math.round(salariuBrut * 0.2125);
//                    int pDoi = (int) Math.round(salariuBrut * 0.0375);
//                    int cass = (int) Math.round(salariuBrut * 0.10);
//                    int asigurari = pUnu + pDoi + cass;
//
//                    int impozit = 0;
//                    if (faraScutiri) {
//                        impozit = (int) (Math.round((salariuBrut - asigurari + bonuri - deductibil) * 0.1));
//                    }
//
//                    int salariuNet = (int) Math.round(salariuBrut - asigurari - impozit);
//
//                    // TODO: Calcul estimativ overtime
//                    double valoareOra = (double) salariuNet / 168;
//                    int OT = (int) Math.round((oreSapt * valoareOra * saptProcent) + (oreSarb * valoareOra * sarbProcent) + (OreWeekend * valoareOra * weekendProcent));
//
//                    //TODO: Output
//                    brut.setText(String.valueOf(Math.round(salariuBrut)));
//                    net.setText(String.valueOf(salariuNet));
//                    pilon1.setText(String.valueOf(pUnu));
//                    pilon2.setText(String.valueOf(pDoi));
//                    CASS.setText(String.valueOf(cass));
//                    Impozit.setText(String.valueOf(impozit));
//                    venitOT.setText(String.valueOf(OT));
//                }
//            }
//        });

        brutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (brutButton.isEnabled()) {
                    sNet = net.getText();
                    double salariuNet = 0;
                    if (!sNet.isEmpty()) {
                        salariuNet = Double.valueOf(sNet);
                    }

                    //TODO: Valoarea in caz ca userul pune "," la zecimala
                    valoareBon = valBon.getText();
                    String[] z = valoareBon.split("");
                    for (int i = 0; i < z.length; i++) {
                        if (z[i].equals(",")) {
                            z[i] = ".";
                        }
                    }
                    StringBuilder x = new StringBuilder();
                    for (int i = 0; i < z.length; i++) {
                        x.append(z[i]);
                    }
                    valoareBon = x.toString();

                    //TODO: Calcul valoare totala a bonurilor
                    numarBon = nrBon.getText();
                    double nrBonuri = 0;
                    if (!numarBon.isEmpty()) {
                        nrBonuri = Double.valueOf(numarBon);
                    }
                    double valBonuri = 0;
                    if (!valoareBon.isEmpty()) {
                        valBonuri = Double.valueOf(valoareBon);
                    }
                    double bonuri = nrBonuri * valBonuri;

                    //TODO: Calcul valoare brut si deduceri
                    int deductibil = 0;
                    double brutTotal = 0;
                    double salariuBrut;
                    if (!faraScutiri) {
                        salariuBrut = salariuNet / 0.65;
                    } else {
                        for (int d = 510; d >= 15; d = d - 15) {
                            brutTotal = Math.round((salariuNet + bonuri * 0.1) / 0.585 - (0.17 * d) + bonuri);
                            if (brutTotal > 3600) {
                                brutTotal = Math.round((salariuNet + bonuri * 0.1) / 0.585 + bonuri);
                                break;
                            } else {
                                if (brutTotal >= 1 && brutTotal <= 1950 && d == 510) {
                                    deductibil = 510;
                                    break;
                                } else if (brutTotal >= 1951 && brutTotal <= 2000 && d == 495) {
                                    deductibil = 495;
                                    break;
                                } else if (brutTotal >= 2001 && brutTotal <= 2050 && d == 480) {
                                    deductibil = 480;
                                    break;
                                } else if (brutTotal >= 2051 && brutTotal <= 2100 && d == 465) {
                                    deductibil = 465;
                                    break;
                                } else if (brutTotal >= 2101 && brutTotal <= 2150 && d == 450) {
                                    deductibil = 450;
                                    break;
                                } else if (brutTotal >= 2151 && brutTotal <= 2200 && d == 435) {
                                    deductibil = 435;
                                    break;
                                } else if (brutTotal >= 2201 && brutTotal <= 2250 && d == 420) {
                                    deductibil = 420;
                                    break;
                                } else if (brutTotal >= 2251 && brutTotal <= 2300 && d == 405) {
                                    deductibil = 405;
                                    break;
                                } else if (brutTotal >= 2301 && brutTotal <= 2350 && d == 390) {
                                    deductibil = 390;
                                    break;
                                } else if (brutTotal >= 2351 && brutTotal <= 2400 && d == 375) {
                                    deductibil = 375;
                                    break;
                                } else if (brutTotal >= 2401 && brutTotal <= 2450 && d == 360) {
                                    deductibil = 360;
                                    break;
                                } else if (brutTotal >= 2451 && brutTotal <= 2500 && d == 345) {
                                    deductibil = 345;
                                    break;
                                } else if (brutTotal >= 2501 && brutTotal <= 2550 && d == 330) {
                                    deductibil = 330;
                                    break;
                                } else if (brutTotal >= 2551 && brutTotal <= 2600 && d == 315) {
                                    deductibil = 315;
                                    break;
                                } else if (brutTotal >= 2601 && brutTotal <= 2650 && d == 300) {
                                    deductibil = 300;
                                    break;
                                } else if (brutTotal >= 2651 && brutTotal <= 2700 && d == 285) {
                                    deductibil = 285;
                                    break;
                                } else if (brutTotal >= 2701 && brutTotal <= 2750 && d == 270) {
                                    deductibil = 270;
                                    break;
                                } else if (brutTotal >= 2751 && brutTotal <= 2800 && d == 255) {
                                    deductibil = 255;
                                    break;
                                } else if (brutTotal >= 2801 && brutTotal <= 2850 && d == 240) {
                                    deductibil = 240;
                                    break;
                                } else if (brutTotal >= 2851 && brutTotal <= 2900 && d == 225) {
                                    deductibil = 225;
                                    break;
                                } else if (brutTotal >= 2901 && brutTotal <= 2950 && d == 210) {
                                    deductibil = 210;
                                    break;
                                } else if (brutTotal >= 2951 && brutTotal <= 3000 && d == 195) {
                                    deductibil = 195;
                                    break;
                                } else if (brutTotal >= 3001 && brutTotal <= 3050 && d == 180) {
                                    deductibil = 180;
                                    break;
                                } else if (brutTotal >= 3051 && brutTotal <= 3100 && d == 165) {
                                    deductibil = 165;
                                    break;
                                } else if (brutTotal >= 3101 && brutTotal <= 3150 && d == 150) {
                                    deductibil = 150;
                                    break;
                                } else if (brutTotal >= 3151 && brutTotal <= 3200 && d == 135) {
                                    deductibil = 135;
                                    break;
                                } else if (brutTotal >= 3201 && brutTotal <= 3250 && d == 120) {
                                    deductibil = 120;
                                    break;
                                } else if (brutTotal >= 3251 && brutTotal <= 3300 && d == 105) {
                                    deductibil = 105;
                                    break;
                                } else if (brutTotal >= 3301 && brutTotal <= 3350 && d == 90) {
                                    deductibil = 90;
                                    break;
                                } else if (brutTotal >= 3351 && brutTotal <= 3400 && d == 75) {
                                    deductibil = 75;
                                    break;
                                } else if (brutTotal >= 3401 && brutTotal <= 3450 && d == 60) {
                                    deductibil = 60;
                                    break;
                                } else if (brutTotal >= 3451 && brutTotal <= 3500 && d == 45) {
                                    deductibil = 45;
                                    break;
                                } else if (brutTotal >= 3501 && brutTotal <= 3550 && d == 30) {
                                    deductibil = 30;
                                    break;
                                } else if (brutTotal >= 3551 && brutTotal <= 3600 && d == 15) {
                                    deductibil = 15;
                                    break;
                                }
                            }
                        }
                        salariuBrut = Math.round(brutTotal - bonuri);
                    }
                    double brutFix = salariuBrut;

                    //TODO: Calcul ore overtime
                    OTSapt = oreSaptamana.getText();
                    double oreSapt = 0;
                    if (!OTSapt.isEmpty()) {
                        oreSapt = Double.valueOf(OTSapt);
                    }
                    procentSapt = procentWeek.getText();
                    double saptProcent = Double.valueOf(procentSapt) / 100;


                    OTSarbatori = oreSarbatori.getText();
                    double oreSarb = 0;
                    if (!OTSarbatori.isEmpty()) {
                        oreSarb = Double.valueOf(OTSarbatori);
                    }
                    procentSarbatori = procentHoliday.getText();
                    double sarbProcent = Double.valueOf(procentSarbatori) / 100;
                    if (ziLibera) {
                        sarbProcent = sarbProcent - 1;
                    }


                    OTWeekend = oreWeekend.getText();
                    double OreWeekend = 0;
                    if (!OTWeekend.isEmpty()) {
                        OreWeekend = Double.valueOf(OTWeekend);
                    }
                    procentWeekend = procentWeekEnd.getText();
                    double weekendProcent = Double.valueOf(procentWeekend) / 100;
                    if (ziLibera) {
                        weekendProcent = weekendProcent - 1;
                    }

                    // TODO: Calcul estimativ overtime
                    double valoareOra = salariuNet / 168;
                    int OT = (int) Math.round((oreSapt * valoareOra * saptProcent) + (oreSarb * valoareOra * sarbProcent) + (OreWeekend * valoareOra * weekendProcent));


                    //TODO: Calcul estimativ CM
                    CMzile = zileCM.getText();
                    double cmZile = 0;
                    if (!CMzile.isEmpty()) {
                        cmZile = Double.valueOf(CMzile);
                    }
                    cmProcent = procentCM.getText();
                    double CMporcent = 1 - Double.valueOf(cmProcent) / 100;
                    double brutZi = brutFix / 21;
                    salariuBrut = Math.round(salariuBrut - (brutZi * CMporcent * cmZile));

                    //TODO: Calcul impozit si asigurari
                    int pUnu = (int) Math.round(salariuBrut * 0.2125);
                    int pDoi = (int) Math.round(salariuBrut * 0.0375);
                    int cass = (int) Math.round(salariuBrut * 0.10);
                    int asigurari = pUnu + pDoi + cass;

                    int impozit = 0;
                    if (faraScutiri) {
                        impozit = (int) (Math.round((salariuBrut - asigurari + bonuri - deductibil) * 0.1));
                    }
                    salariuNet = (int) Math.round(salariuBrut - asigurari - impozit);

                    //TODO: Output

                    net.setText(String.valueOf((int) salariuNet));
                    brut.setText(String.valueOf((int) salariuBrut));
                    pilon1.setText(String.valueOf(pUnu));
                    pilon2.setText(String.valueOf(pDoi));
                    CASS.setText(String.valueOf(cass));
                    Impozit.setText(String.valueOf(impozit));
                    venitOT.setText(String.valueOf(OT));
                }
            }
        });
    }

    private double getDeductibil(double brutTotal) {
        double deductibil = 0;
        if (brutTotal >= 1 && brutTotal <= 1950) {
            deductibil = 510;
        } else if (brutTotal >= 1951 && brutTotal <= 2000) {
            deductibil = 495;
        } else if (brutTotal >= 2001 && brutTotal <= 2050) {
            deductibil = 480;
        } else if (brutTotal >= 2051 && brutTotal <= 2100) {
            deductibil = 465;
        } else if (brutTotal >= 2101 && brutTotal <= 2150) {
            deductibil = 450;
        } else if (brutTotal >= 2151 && brutTotal <= 2200) {
            deductibil = 435;
        } else if (brutTotal >= 2201 && brutTotal <= 2250) {
            deductibil = 420;
        } else if (brutTotal >= 2251 && brutTotal <= 2300) {
            deductibil = 405;
        } else if (brutTotal >= 2301 && brutTotal <= 2350) {
            deductibil = 390;
        } else if (brutTotal >= 2351 && brutTotal <= 2400) {
            deductibil = 375;
        } else if (brutTotal >= 2401 && brutTotal <= 2450) {
            deductibil = 360;
        } else if (brutTotal >= 2451 && brutTotal <= 2500) {
            deductibil = 345;
        } else if (brutTotal >= 2501 && brutTotal <= 2550) {
            deductibil = 330;
        } else if (brutTotal >= 2551 && brutTotal <= 2600) {
            deductibil = 315;
        } else if (brutTotal >= 2601 && brutTotal <= 2650) {
            deductibil = 300;
        } else if (brutTotal >= 2651 && brutTotal <= 2700) {
            deductibil = 285;
        } else if (brutTotal >= 2701 && brutTotal <= 2750) {
            deductibil = 270;
        } else if (brutTotal >= 2751 && brutTotal <= 2800) {
            deductibil = 255;
        } else if (brutTotal >= 2801 && brutTotal <= 2850) {
            deductibil = 240;
        } else if (brutTotal >= 2851 && brutTotal <= 2900) {
            deductibil = 225;
        } else if (brutTotal >= 2901 && brutTotal <= 2950) {
            deductibil = 210;
        } else if (brutTotal >= 2951 && brutTotal <= 3000) {
            deductibil = 195;
        } else if (brutTotal >= 3001 && brutTotal <= 3050) {
            deductibil = 180;
        } else if (brutTotal >= 3051 && brutTotal <= 3100) {
            deductibil = 165;
        } else if (brutTotal >= 3101 && brutTotal <= 3150) {
            deductibil = 150;
        } else if (brutTotal >= 3151 && brutTotal <= 3200) {
            deductibil = 135;
        } else if (brutTotal >= 3201 && brutTotal <= 3250) {
            deductibil = 120;
        } else if (brutTotal >= 3251 && brutTotal <= 3300) {
            deductibil = 105;
        } else if (brutTotal >= 3301 && brutTotal <= 3350) {
            deductibil = 90;
        } else if (brutTotal >= 3351 && brutTotal <= 3400) {
            deductibil = 75;
        } else if (brutTotal >= 3401 && brutTotal <= 3450) {
            deductibil = 60;
        } else if (brutTotal >= 3451 && brutTotal <= 3500) {
            deductibil = 45;
        } else if (brutTotal >= 3501 && brutTotal <= 3550) {
            deductibil = 30;
        } else if (brutTotal >= 3551 && brutTotal <= 3600) {
            deductibil = 15;
        }
        return deductibil;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Salary Calculator");
        frame.setContentPane(new a().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
