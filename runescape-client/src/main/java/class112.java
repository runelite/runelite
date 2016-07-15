import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public class class112 {
   static {
      new HashMap();
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1824064070"
   )
   static final void method2509() {
      client.field490 = 0;
      int var0 = (class118.field2035.field896 >> 7) + class19.field286;
      int var1 = (class118.field2035.field879 >> 7) + class6.field128;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         client.field490 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         client.field490 = 1;
      }

      if(client.field490 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         client.field490 = 0;
      }

   }
}
