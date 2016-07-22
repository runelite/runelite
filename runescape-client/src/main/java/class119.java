import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class119 {
   @ObfuscatedName("m")
   Inflater field2033;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class119(int var1, int var2, int var3) {
   }

   public class119() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1077245948"
   )
   static final void method2516(boolean var0) {
      for(int var1 = 0; var1 < client.field394; ++var1) {
         class36 var2 = client.field308[client.field310[var1]];
         int var3 = 536870912 + (client.field310[var1] << 14);
         if(var2 != null && var2.vmethod786() && var0 == var2.field802.field909 && var2.field802.method798()) {
            int var4 = var2.field864 >> 7;
            int var5 = var2.field831 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field858 == 1 && (var2.field864 & 127) == 64 && (var2.field831 & 127) == 64) {
                  if(client.field376[var4][var5] == client.field377) {
                     continue;
                  }

                  client.field376[var4][var5] = client.field377;
               }

               if(!var2.field802.field935) {
                  var3 -= Integer.MIN_VALUE;
               }

               class5.field91.method2010(class51.field1119, var2.field864, var2.field831, class15.method163(var2.field858 * 64 - 64 + var2.field864, var2.field858 * 64 - 64 + var2.field831, class51.field1119), var2.field858 * 64 - 64 + 60, var2, var2.field832, var3, var2.field891);
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass122;[BI)V",
      garbageValue = "-213277221"
   )
   public void method2517(class122 var1, byte[] var2) {
      if(var1.field2047[var1.field2045] == 31 && var1.field2047[1 + var1.field2045] == -117) {
         if(null == this.field2033) {
            this.field2033 = new Inflater(true);
         }

         try {
            this.field2033.setInput(var1.field2047, 10 + var1.field2045, var1.field2047.length - (8 + var1.field2045 + 10));
            this.field2033.inflate(var2);
         } catch (Exception var4) {
            this.field2033.reset();
            throw new RuntimeException("");
         }

         this.field2033.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)[Lclass193;",
      garbageValue = "-13"
   )
   public static class193[] method2518() {
      return new class193[]{class193.field3101, class193.field3100, class193.field3115, class193.field3102, class193.field3112, class193.field3105, class193.field3113, class193.field3107, class193.field3114, class193.field3103, class193.field3108, class193.field3106, class193.field3109, class193.field3104, class193.field3110};
   }
}
