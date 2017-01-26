import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class146 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 188202713
   )
   static int field2022;
   @ObfuscatedName("p")
   Inflater field2023;
   @ObfuscatedName("ry")
   protected static String field2025;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lclass189;",
      garbageValue = "1860857952"
   )
   public static class189 method2748(int var0) {
      class189 var1 = (class189)class189.field2781.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class189.field2786.getConfigData(15, var0);
         var1 = new class189();
         if(var2 != null) {
            var1.method3441(new Buffer(var2));
         }

         class189.field2781.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class146(int var1, int var2, int var3) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "-1186740839"
   )
   public void method2749(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(null == this.field2023) {
            this.field2023 = new Inflater(true);
         }

         try {
            this.field2023.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 10 + 8));
            this.field2023.inflate(var2);
         } catch (Exception var4) {
            this.field2023.reset();
            throw new RuntimeException("");
         }

         this.field2023.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class146() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)LSequence;",
      garbageValue = "-25"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3047.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3046.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method3747(new Buffer(var2));
         }

         var1.method3749();
         Sequence.field3047.put(var1, (long)var0);
         return var1;
      }
   }
}
