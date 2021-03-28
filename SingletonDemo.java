import HOMEWORK1.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class SingletonDemo 
{
public static void main(String[] args) 
{
Singleton tmp = Singleton.getInstance();
tmp.play();
tmp.open();
tmp.close();
tmp.openbuttonpressed();
tmp.push();
}
}