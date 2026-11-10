package recursividadfinal;
public class Metodoxd {
    public int Ecuacion(String s){
        try{
            return EcuacionRecursiva(s);
        } catch(Exception e){
           System.out.println("Error de formato ");
           return 0;
        }
    }
    
    public int EcuacionRecursiva(String s) throws Exception{
        if(s.matches("-?\\d+")) return Integer.parseInt(s);
        
        int posParIz = s.lastIndexOf('(');
        if(posParIz != -1){
            int posParDe = s.indexOf(')', posParIz);
            if(posParDe == -1) throw new Exception("Error de formato");
            int res = EcuacionRecursiva(s.substring(posParIz+1, posParDe));
            return EcuacionRecursiva(s.substring(0, posParIz) + res + s.substring(posParDe+1));
        }

        int posMult = s.indexOf('*');
        if (posMult != -1) {
            int posIz = posMult - 1;
            while(posIz >= 0 && (Character.isDigit(s.charAt(posIz)) || 
                (s.charAt(posIz) == '-' && 
                (posIz == 0 || !Character.isDigit(s.charAt(posIz-1)))))){
                posIz--;
            }
            posIz++;
            
        int posDe = posMult + 1;
        if(posDe < s.length() && s.charAt(posDe) == '-'){
            posDe++;
        }
        while(posDe < s.length() && Character.isDigit(s.charAt(posDe))){
            posDe++;
        }
        int N1 = Integer.parseInt(s.substring(posIz, posMult));
        int N2 = Integer.parseInt(s.substring(posMult+1, posDe));
        int resultado = N1*N2;
        return EcuacionRecursiva(s.substring(0,posIz) + resultado + s.substring(posDe));
        }
        
        for(int i = 1; i < s.length();i++){
            char c = s.charAt(i);
            if((c == '+' || c == '-') && (Character.isDigit(s.charAt(i-1)) ||
            s.charAt(-1) == ')')){
                int posIz = i - 1;
                while(posIz >= 0 && (Character.isDigit(s.charAt(posIz)) ||
                    (s.charAt(posIz) == '-' && (posIz == 0 ||
                    !Character.isDigit(s.charAt(posIz - 1)))))){
                    posIz--;
                }
                posIz++;
                
                int posDe = i + 1;
                if(posDe < s.length() && s.charAt(posDe) == '-'){
                    posDe++;
                }
                while(posDe < s.length() && Character.isDigit(s.charAt(posDe))){
                    posDe++;
                }
                
                int N1 = Integer.parseInt(s.substring(posIz,i));
                int N2 = Integer.parseInt(s.substring(i+1,posDe));
                int resultado;
                if (c == '+'){
                    resultado = N1 + N2;
                } else {
                    resultado = N1 - N2;
                }
                return EcuacionRecursiva(s.substring(0,posIz)+resultado+s.substring(posDe));
            }
        }
        throw new Exception("Error de formato "+s);
    }
}