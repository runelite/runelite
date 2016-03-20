import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cp")
public final class class93 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 304511389
   )
   int field1590;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1403017975
   )
   int field1591;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1895479415
   )
   int field1592;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2137982489
   )
   int field1593;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 406322495
   )
   int field1594;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1612193253
   )
   int field1595;
   @ObfuscatedName("m")
   public class84 field1596;
   @ObfuscatedName("j")
   public class84 field1597;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -316885593
   )
   public int field1598 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1430743955
   )
   int field1599 = 0;
   @ObfuscatedName("q")
   static class13 field1600;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1898743395
   )
   int field1604;

   @ObfuscatedName("dk")
   static final void method2182(String var0, int var1) {
      client.field301.method2753(153);
      client.field301.method2497(class22.method578(var0) + 1);
      client.field301.method2503(var0);
      client.field301.method2648(var1);
   }

   @ObfuscatedName("dc")
   static String method2183(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(client.field295 == 1) {
         var0 = var0 + "-wtrc";
      } else if(2 == client.field295) {
         var0 = var0 + "-wtqa";
      } else if(3 == client.field295) {
         var0 = var0 + "-wtwip";
      } else if(5 == client.field295) {
         var0 = var0 + "-wti";
      } else if(4 == client.field295) {
         var0 = "local";
      }

      String var3 = "";
      if(class3.field58 != null) {
         var3 = "/p=" + class3.field58;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field298 + "/a=" + client.field299 + var3 + "/";
   }
}
