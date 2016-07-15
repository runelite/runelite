import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class141 {
   @ObfuscatedName("l")
   public static String field2181 = null;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -1746083447
   )
   static int field2186;
   @ObfuscatedName("e")
   public static Applet field2187 = null;

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "2106898884"
   )
   static final void method3039(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field427.method3899(); null != var10; var10 = (class16)client.field427.method3918()) {
         if(var10.field238 == var0 && var10.field232 == var1 && var10.field242 == var2 && var3 == var10.field231) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class16();
         var9.field238 = var0;
         var9.field231 = var3;
         var9.field232 = var1;
         var9.field242 = var2;
         class5.method53(var9);
         client.field427.method3895(var9);
      }

      var9.field237 = var4;
      var9.field240 = var5;
      var9.field236 = var6;
      var9.field239 = var7;
      var9.field230 = var8;
   }
}
