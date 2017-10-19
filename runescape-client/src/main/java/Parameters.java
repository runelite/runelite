import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ja")
@Implements("Parameters")
public class Parameters {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3716;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3723;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3714;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3715;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3727;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3724;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   public static final Parameters field3726;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3717;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3718;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3722;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3719;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3728;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   public static final Parameters field3721;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3720;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final Parameters field3725;
   @ObfuscatedName("i")
   @Export("key")
   public final String key;

   static {
      field3716 = new Parameters("4", "4");
      field3715 = new Parameters("13", "13");
      field3727 = new Parameters("10", "10");
      field3717 = new Parameters("5", "5");
      field3718 = new Parameters("15", "15");
      field3719 = new Parameters("11", "11");
      field3720 = new Parameters("8", "8");
      field3722 = new Parameters("12", "12");
      field3714 = new Parameters("7", "7");
      field3723 = new Parameters("14", "14");
      field3724 = new Parameters("1", "1");
      field3725 = new Parameters("6", "6");
      field3721 = new Parameters("3", "3");
      field3726 = new Parameters("9", "9");
      field3728 = new Parameters("2", "2");
   }

   Parameters(String var1, String var2) {
      this.key = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-562115419"
   )
   static boolean method4989(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field692.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var11.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var10 = class52.method763(class56.field693, var2, new Object[]{(new URL(class56.field693.getCodeBase(), var0)).toString()});
            return var10 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field693.getAppletContext().showDocument(new URL(class56.field693.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class56.field693;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var9) {
            ;
         }

         try {
            class56.field693.getAppletContext().showDocument(new URL(class56.field693.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
