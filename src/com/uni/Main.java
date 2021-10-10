package com.uni;

import org.junit.Assert;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Aufgabe1_Test();
        Aufgabe2_Test();
        Aufgabe3_Test();
        Aufgabe4_Test();
    }

    private static void Aufgabe1_Test()
    {
        System.out.print("Aufgabe 1: ");
        int[] noten = {1, 3, 2, 2, 5, 10, 100, 33, 44, 40};
        Aufgabe1 a1 = new Aufgabe1(noten);

        Assert.assertArrayEquals(a1.nichtAusreichendeNoten(), (new int[]{1, 3, 2, 2, 5, 10, 33}) );
        Assert.assertEquals(a1.durchschnittswert(), 24);
        Assert.assertArrayEquals(a1.abgerundeteNoten(), (new int[]{1, 3, 2, 2, 5, 10, 100, 33, 45, 40}) );
        Assert.assertEquals(a1.maximaleAbgerundeteNote(), 45);

        System.out.print("\nAufgabe 1 End \n\n");
    }

    private static void Aufgabe2_Test()
    {
        System.out.print("Aufgabe 2: \n");

        int[] myNum = {1, 2, 3, 7, 2};
        Aufgabe2 a2 = new Aufgabe2(myNum);
        Assert.assertEquals(a2.maxZahl(), 7);
        Assert.assertEquals(a2.minZahl(), 1);
        Assert.assertEquals(a2.maximaleSumme(), 14);
        Assert.assertEquals(a2.minimaleSumme(), 8);

        System.out.print("Aufgabe 2 End \n\n");
    }

    private static void Aufgabe3_Test()
    {
        System.out.print("Aufgabe 3: \n");
        int[] ersteZahl = {8, 3, 0, 1};
        int[] zweiteZahl = {1, 7, 0, 0};
        int[] dritteZahl = {7, 5, 0, 1};
        int[] vierteZahl = {2, 3, 6, 0};
        int ziffer = 2;

        Aufgabe3 a3 = new Aufgabe3(ersteZahl, zweiteZahl);
        Aufgabe3 a3_2 = new Aufgabe3(dritteZahl, ziffer);
        Aufgabe3 a3_3 = new Aufgabe3(vierteZahl, ziffer);

        Assert.assertArrayEquals(a3.Summe(), new int[] {1, 0, 0, 0, 1});
        Assert.assertArrayEquals(a3.Differenz(), new int[] {6, 6, 0, 1});
        Assert.assertArrayEquals(a3_2.Multiplikation(), new int[] {1, 5, 0, 0, 2});
        Assert.assertArrayEquals(a3_2.Division(), new int[] {3, 7, 5, 0});
        Assert.assertArrayEquals(a3_3.Multiplikation(), new int[] {4, 7, 2, 0});
        Assert.assertArrayEquals(a3_3.Division(), new int[] {1, 1, 8, 0});
        System.out.print("Aufgabe 3 End \n\n");

    }

    private static void Aufgabe4_Test()
    {
        System.out.print("Aufgabe 4: \n");
        double[] tastatur = {1, 2, 3, 4}, usb = {6, 7, 8, 9, 10};
        double[] tastatur2 = {40, 50, 60}, usb2 = {8, 12};
        double[] tastatur3 = {60}, tastatur4 = {40, 60};

        double buget = 30, buget2 = 60;
        Aufgabe4 a4 = new Aufgabe4(tastatur, usb, buget);
        Aufgabe4 a4_2 = new Aufgabe4(tastatur2, usb2, buget2);
        Aufgabe4 a4_3 = new Aufgabe4(tastatur3, usb2, buget2);
        Aufgabe4 a4_4 = new Aufgabe4(tastatur4, usb2, buget2);

        Assert.assertEquals(a4.billigsteTastatur(), 1,0);
        Assert.assertEquals(a4.teuerstenGestand(), 10, 0);
        Assert.assertEquals(a4.teuersteUSBKaufen(), 10, 0);
        Assert.assertEquals(a4.maximalKaufen(), 14, 0);
        Assert.assertEquals(a4_2.maximalKaufen(), 58, 0);
        Assert.assertEquals(a4_3.maximalKaufen(), -1, 0);
        Assert.assertEquals(a4_4.maximalKaufen(), 52, 0);

        System.out.print("Aufgabe 4 End \n");
    }
}

//Aufgabe 1
class Aufgabe1 {
    /*  Vorbedingung:     ein Array mit positiven, ganzen Zahlen zwischen 0 und 100 */
    private int noten[];

    public Aufgabe1(int n[]) {
        noten = n;
    }

    //a)
    /*  Nachbedingung:  ein Array mit nicht ausreichende Note */
    public int[] nichtAusreichendeNoten()               //die "nichtAusreichendeNoten"-Methode gibt ein Array mit alle Werten < 40 zuruck
    {
        int j = 0, k = 0;
        for (int i = 0; i < noten.length; i++)          //wir durchlaufen das Array, um die Anzahl der Werten < 40 zu finden
        {
            if (noten[i] < 40) {
                j++;
            }
        }

        int newArray[] = new int[j];                    //wir erstellen ein neues Array, wo wir die nicht ausreichenden Noten schreiben werden
        for (int i = 0; i < noten.length; i++)
        {
            if (noten[i] < 40) {
                newArray[k] = noten[i];
                k++;
            }
        }

        return newArray;
    }

    //b)
    /*  Nachbedingung: wir geben den Durchschnittswert des Arrays zuruck */
    public int durchschnittswert()                      //die "durchschnittswert"-Methode rechnet den Durchschnittswert der Noten
    {
        int durchschnitt = 0;
        for (int i = 0; i < noten.length; i++) {        //wir durchlaufen das Array, um die Summe der Noten zu rechnen
            durchschnitt += noten[i];
        }

        return durchschnitt/noten.length;
    }

    //c)
    /*  Vorbedingung: eine ganze Zahl */
    /*  Nachbedingung: die abgerundete Zahl */
    /*  Ausnahmen: die Zahlen < 38 werden nicht aberundet */
    private int noteRunden(int note)                    //die "noteRunden"-Methode rechnet die agberundete Note
    {
        if (note < 38) {
            return note;
        }
        else {
            if (note % 10 == 0 || note % 10 == 5)       //die Zahl ist ein Vielfach von 5 => nicht abgerundet
                return note;

            if (note % 10 > 0 && note % 10 < 5) {       //falls die Differenz zwischen der Note und dem nächsten Vielfachen von 5 weniger als 3 ist => abgerundet
                if (5 - note % 10 < 3)
                    return note / 10 * 10 + 5;
                else
                    return note / 10 * 10;
            } else {
                if (note % 10 > 5 && note % 10 < 10) {
                    if (10 - note % 10 < 3)
                        return note / 10 * 10 + 10;
                    else
                        return note / 10 * 10 + 5;
                }
            }
        }
        return note;
    }

    /*  Nachbedingung: ein Array mit die abgerundete Noten liefern */
    public int[] abgerundeteNoten()                         //die "abgerundeteNoten"-Methode zeigt alle abgerundeten Noten
    {
        int[] newArray = new int[noten.length];
        for (int i = 0; i < noten.length; i++) {             //wir runden jede Zahl aus dem Array
            newArray[i] = noteRunden(noten[i]);
        }

        return newArray;
    }

    //d)
    /*  Nachbedingung: die maximale abgerundete Note liefern */
    public int maximaleAbgerundeteNote()                    //die "maximaleAbgerundeteNote"-Methode gibt die maximale abgerundete Note aus dem Array zuruck
    {
        int[] newArray;
        newArray = abgerundeteNoten();
        int max = 0;

        for (int i = 0; i < noten.length; i++) {            //wir suchen die maximale Note, die abgerundet ist und die am Anfang an kein Vielfach von 5 war
            if (newArray[i] >= 38 && newArray[i] > max && noten[i] % 10 != 0 && noten[i] % 10 != 5)
                max = newArray[i];
        }
        return max;
    }


}

class Aufgabe2{
    /*  Vorbedingung:     ein Array mit positiven Zahlen */
    private int zahlen[];

    public Aufgabe2(int z[]) {
        zahlen = z;
    }

    //a)
    /*  Nachbedingung: die maximale Zahl rechnen*/
    public int maxZahl(){                                   //die "maxZahl"-Methode gibt die maximale Zahl zuruck
        int max = zahlen[0];
        for (int i = 1; i < zahlen.length; i++)             //wir durchlaufen das Array, die maximale Zahl fu finden
        {
            if (max < zahlen[i])
                max = zahlen[i];
        }

        return max;
    }

    //b)
    /*  Nachbedingung: die minimale Zahl rechnen*/
    public int minZahl(){                                   //die "minZahl"-Methode gibt die minimale Zahl zuruck
        int min = zahlen[0];
        for (int i = 0; i < zahlen.length; i++)             //wir durchlaufen das Array, die minimale Zahl zu finden
        {
            if (min > zahlen[i])
                min = zahlen[i];
        }

        return min;
    }

    //c)
    /*  Nachbedingung: die maximale Summe von n-1 Zahlen rechnen*/
    public int maximaleSumme(){                             //die "maximaleSumme"-Methode gibt die maximale Summe zuruck
        int summe = 0;

        for (int i = 0; i < zahlen.length; i++)             //wir rechnen die Summe der allen Zahlen ohne der minimale Zahl
        {
            summe += zahlen[i];
        }

        summe -= minZahl();
        return summe;
    }

    //d)
    /*  Nachbedingung: die minimale Summe von n-1 Zahlen */
    public int minimaleSumme(){                             //die "minimaleSumme"-Methode gibt die minimale Summe zuruck
        int summe = 0;
        for (int i = 0; i < zahlen.length; i++)             //wir rechnen die Summe der allen Zahlen ohne der maxiale Zahl
        {
            summe += zahlen[i];
        }

        summe -= maxZahl();
        return summe;
    }
}


class Aufgabe3{
    /*  Vorbedingung:     eine Ziffer und zwei Arrays, die zwei grose Zahlen beschreiben */

    private int ersteZahl[];
    private int zweiteZahl[];
    private int ziffer;

    public Aufgabe3(int ez[], int zz[])
    {
        ersteZahl = ez;
        zweiteZahl = zz;
    }

    public Aufgabe3(int ez[], int ziff)
    {
        ersteZahl = ez;
        ziffer = ziff;
    }

    //a)
    /*  Nachbedingung: die Summe der Zahlen rechnen */
    public int[] Summe()                                        //die "Summe"-Methode gibt die Summe der zwei Zahlen zuruck
    {
        int[] summe = new int[ersteZahl.length + 1];
        for (int i = ersteZahl.length - 1; i >= 0; i--) {       //wir addieren die Ziffer von rechts nach links
            if (summe[i + 1] + ersteZahl[i] + zweiteZahl[i] >= 10)  //wir sehen, ob die Summe > 10 ist, um zu der nachsten Summe eine 1 zu addieren
            {
                summe[i + 1] = (summe[i + 1] + ersteZahl[i] + zweiteZahl[i]) % 10;
                summe[i] += 1;
            }
            else
            {
                summe[i + 1] += (ersteZahl[i] + zweiteZahl[i]) % 10;
            }
        }

        if (summe[0] == 0) {
            for (int i = 0; i < summe.length - 1; i++) {
                summe[i] = summe[i + 1];
            }

            int[] newArray = new int[summe.length - 1];
            for (int i = 0; i < summe.length - 1; i++) {
                newArray[i] = summe[i];
            }

            summe = newArray;

        }

        return summe;
    }

    //b)
    /*  Nachbedingung: die Differenz der Zahlen rechnen */
    public int[] Differenz()                                        //die "Differenz"-Methode gibt die Differenz der zwei Zahlen zuruck
    {
        int zahl = 0, zahl2 = 0, zahl3 = 0, k = 0;

        for (int i = 0; i < ersteZahl.length; i++) {                //wir rechnen die Differenz zwischen die zwei Zahlen
            zahl = zahl * 10 + ersteZahl[i];
            zahl2 = zahl2 * 10 + zweiteZahl[i];
        }

        zahl3 = zahl;

        while (zahl3 != 0)
        {
            k++;
            zahl3 = zahl3 / 10;
        }

        zahl = zahl - zahl2;

        int[] differenz = new int[k];
        for (int i = k - 1; i >= 0; i--) {                          //wir schreiben die Differenz in einem Array
            differenz[i] = zahl % 10;
            zahl = zahl / 10;
        }

        return differenz;
    }

    //c)
    /*  Nachbedingung: die Multiplikation der Zahlen rechnen */
    public int[] Multiplikation()                       //die "Multiplikation"-Methode gibt die Multiplikation der zwei Zahlen zuruck
    {
        int zahl = 0, zahl2 = 0, k = 0;

        for (int i = 0; i < ersteZahl.length; i++) {
            zahl = zahl * 10 + ersteZahl[i];
        }
        zahl = zahl * ziffer;
        zahl2 = zahl;

        while (zahl2 != 0)
        {
            k++;
            zahl2 = zahl2 / 10;
        }

        int[] multiplikation = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            multiplikation[i] = zahl % 10;
            zahl = zahl / 10;
        }

        return multiplikation;
    }

    //d)
    /*  Nachbedingung: die Division der Zahlen rechnen */
    public int[] Division()                             //die "Division"-Methode gibt die Division der zwei Zahlen zuruck
    {
        int zahl = 0, zahl2 = 0, k = 0;

        for (int i = 0; i < ersteZahl.length; i++) {
            zahl = zahl * 10 + ersteZahl[i];
        }
        zahl = zahl / ziffer;
        zahl2 = zahl;

        while (zahl2 != 0)
        {
            k++;
            zahl2 = zahl2 / 10;
        }

        int[] division = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            division[i] = zahl % 10;
            zahl = zahl / 10;
        }

        return division;
    }
}

class Aufgabe4{
    /*  Vorbedingung:     eine Zahl (das Budget) und zwei Arrays, die Preise beschreiben (fur Tastaturen und USBs) */
    private double tastatur[];
    private double usb[];
    private double budget;

    public Aufgabe4(double t[], double u[], double b)
    {
        tastatur = t;
        usb = u;
        budget = b;
    }

    //a)
    /*  Nachbedingung: die billigste Tastatur zurückgeben */
    public double billigsteTastatur()                           //die "billigsteTastatur"-Methode gibt die billigste Tastatur zuruck
    {
        double min = tastatur[0];
        for (int i = 0; i < tastatur.length; i++) {             //wir durchlaufen das Array fur Tastatur, um die billigste Tastatur zu finden
            if (min > tastatur[i])
                min = tastatur[i];
        }

        return min;
    }

    //b)
    /*  Nachbedingung: der teuersten Gegenstand zurückgeben */
    public double teuerstenGestand()                            //die "teuerstenGestand"-Methode gibt die teuerste Gestand zuruck
    {
        double max = tastatur[0];
        for (int i = 1; i < tastatur.length; i++)               //wir durchlaufen die Arrays fur Tastatur und USBs, um die teuerste Gegenstand zu finden
        {
            if (max < tastatur[i])
                max = tastatur[i];
        }

        for (int i = 1; i < usb.length; i++)
        {
            if (max < usb[i])
                max = usb[i];
        }

        return max;
    }

    //c)
    /*  Nachbedingung: das teuerste USB Laufwerk zurückgeben, das man mit dem Budget kaufen kann */
    public double teuersteUSBKaufen()                           //die "teuersteUSBKaufen"-Methode gibt das teuerste USB zuruck, das man mit dem Budget kaufen kann
    {
        double max = usb[0], max2 = usb[0];
        for (int i = 0; i < usb.length; i++) {                  //wir suchen die grose Zahl, kleiner als das Budget
            if (usb[i] < budget && usb[i] >= max2)
            {
                max = usb[i];
            }
        }
        return max;
    }

    //d)
    /*  Nachbedingung: der maximalen Geldbetrag, der man mit dem Budget eine Tastatur und ein USB kaufen kann */
    /*  Ausnahmen: -1, falls der minimalen Geldbetrag > als dem Budget ist */
    public double maximalKaufen()                               //die "maximalKaufen"-Methode gibt die maximale Summe zuruck, das man mit dem Budget eine Tastatur und ein USB kaufen kann
    {
        double preis = -1, max = 0;
        double[] arrayPreis = new double[tastatur.length * usb.length];
        int k = 0;

        for (int i = 0; i < tastatur.length; i++) {                  //wir rechnen alle Moglichkeiten, eine Tastatur und ein USB zu kaufen
            for (int j = 0; j < usb.length; j++) {
                arrayPreis[k] = tastatur[i] + usb[j];
                k++;
            }
        }

        for (int i = 0; i < arrayPreis.length; i++) {               //wir suchen den maximalen Geldbetrag
                if (arrayPreis[i] < budget && arrayPreis[i] > max)
                    preis = arrayPreis[i];
                    max = preis;

        }

        return preis;
    }
}


