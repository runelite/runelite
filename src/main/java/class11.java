import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("n")
public class class11 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 785895833
   )
   static int field170 = 0;
   @ObfuscatedName("w")
   static final class198 field171 = new class198(1024);
   @ObfuscatedName("e")
   static final Map field172 = new HashMap();
   @ObfuscatedName("f")
   static final class200 field173 = new class200();

   @ObfuscatedName("l")
   static final int method154(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("u")
   static final void method155() {
      if(null != class5.field94) {
         class5.field94.method1175();
      }

      if(null != class221.field3179) {
         class221.field3179.method1175();
      }

   }

   @ObfuscatedName("cz")
   static final void method156(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field331) {
         if(client.field420 < 500) {
            client.field425[client.field420] = var0;
            client.field426[client.field420] = var1;
            client.field301[client.field420] = var2;
            client.field391[client.field420] = var3;
            client.field494[client.field420] = var4;
            client.field422[client.field420] = var5;
            ++client.field420;
         }

      }
   }
}
