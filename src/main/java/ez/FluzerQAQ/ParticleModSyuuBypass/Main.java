package ez.FluzerQAQ.ParticleModSyuuBypass;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import org.lwjgl.opengl.Display;@
Mod(modid = "ni7t87llt9e1", version = "1.02", acceptedMinecraftVersions = "1.8.9")
public class Main
{
    public static final String MODID = "ni7t87llt9e1";
    public static final String VERSION = "1.02";
    private String[] blacklist = new String[]
    {
        "particlemod"
    };
    @EventHandler
    public void init(FMLLoadCompleteEvent event) throws URISyntaxException
    {
        LoadController modController = null;
        try
        {
            Field field = Loader.class.getDeclaredField("modController");
            field.setAccessible(true);
            modController = (LoadController) field.get(Loader.instance());
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch(NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        ModContainer[] arrayOfModContainer;
        for(int j = (arrayOfModContainer = (ModContainer[]) modController.getActiveModList().toArray((Object[]) new ModContainer[modController.getActiveModList().size()])).length, i = 0; i < j;)
        {
            ModContainer mod = arrayOfModContainer[i];
            if(isblackmod(mod.getModId()))
            {
                builder.append("name: " + mod.getName()).append(", modid: ").append(mod.getModId()).append("\n");
                modController.getActiveModList().remove(mod);
            }
            i++;
        }
    }
    public boolean isblackmod(String modid)
    {
        String[] arrayOfString;
        for(int j = (arrayOfString = this.blacklist).length, i = 0; i < j;)
        {
            String id = arrayOfString[i];
            if(id.equalsIgnoreCase(modid)) return true;
            i++;
        }
        return false;
    }
}