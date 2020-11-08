package com.company;

import java.util.Random;

public class Main {
    public static StringBuilder random(int k)
    {
        StringBuilder st= new StringBuilder("1");
        Random random= new Random();
        for(int i=1; i<k; i++)
        {
            st.append(random.nextInt(2));
        }
        return st;
    }

    public static void crc(StringBuilder  st, int k)
    {
        String poly = "10001001";
        int N = poly.length()-1;
        System.out.println("Полином              - > " + poly);
        System.out.print("Выходящее  сообщение - > "+st);
        for (int i = 0; i < N; i++)
        {
            st.append(0);
        }
        /*System.out.println("Изменённое сообщение - > "+st);*/
        /*StringBuilder test = new StringBuilder();
        test.append("110010110100011101");
        System.out.println("Тестовое сообщение   - > " + test);*/
        StringBuilder crc = new StringBuilder();
        for (int j = 0; j < N; j++)
        {
            crc.append(st.charAt(j));
        }
        st.delete(0,N);
        int l=0;
        while (st.length() != 0)
        {
            for (int j = 0; j < N; j++)
            {
                if (crc.charAt(j) == poly.charAt(j))
                {
                    crc.replace(j, j + 1, "0");
                } else crc.replace(j, j + 1, "1");
            }
            int i = crc.indexOf("1");
            if (i==-1) i=N;
            while (st.length()>0 & i>0)
                {
                    crc.delete(0, 1);
                    crc.append(st.charAt(0));
                    st.delete(0, 1);
                    i--;
                }
        }
        for (int j = 0; j < N; j++)
        {
            if (crc.charAt(j) == poly.charAt(j))
            {
                crc.replace(j, j + 1, "0");
            }
            else crc.replace(j, j + 1, "1");
        }
        System.out.println(crc);
        System.out.println("Crc                  - > "+crc);

    }

    public static void main(String[] args)
    {
        int  K=1000;
	    StringBuilder posl= random(K);
	    System.out.println("Входящее   сообщение - > "+posl);
	    crc(posl,K);
    }
}
