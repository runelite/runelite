import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
final class class18 implements Comparator {
   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field325;
   @ObfuscatedName("o")
   @Export("offsetsY")
   static int[] offsetsY;
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lv;Lv;I)I",
      garbageValue = "1202764882"
   )
   int method146(class14 var1, class14 var2) {
      return var1.method88().compareTo(var2.method88());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method146((class14)var1, (class14)var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1923000935"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class294.field3904 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class294.field3904.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class294.field3904.close();
            } catch (Exception var3) {
               ;
            }

            ++class239.field3274;
            class294.field3904 = null;
         }

      }
   }
}
