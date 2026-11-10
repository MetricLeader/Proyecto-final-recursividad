package recursividadfinal;
public class RecursividadFinal {
    public static void main(String[] args) throws Exception {
        Metodoxd Metodo = new Metodoxd();
        
        int pri = Metodo.Ecuacion("7+10+2");        
        System.out.println(pri);
        int seg = Metodo.Ecuacion("1+5*(7-1)+10");
        System.out.println(seg);
        int ter = Metodo.Ecuacion("5+7+(1+2*(8-9)+2)-10");
        System.out.println(ter);
        int cua = Metodo.Ecuacion("9-2*(75-9+(6+3+(1+2)*1)+7)+9");
        System.out.println(cua);
        int cin = Metodo.Ecuacion("5++1+10");
        System.out.println(cin);
        int sei = Metodo.Ecuacion("-5+10");
        System.out.println(sei);
        int sie = Metodo.Ecuacion("74-7/7");
        System.out.println(sie);
        int och = Metodo.Ecuacion("10+9-A");
        System.out.println(och);
    }   
}