import java.io.File;
import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("h")
   public static File field1829;
   @ObfuscatedName("pl")
   static GarbageCollectorMXBean field1830;
   @ObfuscatedName("am")
   static int[] field1832;
   @ObfuscatedName("i")
   Frame[] field1834;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "50"
   )
   public boolean method2323(int var1) {
      return this.field1834[var1].field1599;
   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IZ)V",
      garbageValue = "0"
   )
   public Frames(class170 var1, class170 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3299(var3);
      this.field1834 = new Frame[var6];
      int[] var7 = var1.method3298(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3292(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3845(); var12 != null; var12 = (FrameMap)var5.method3847()) {
            if(var11 == var12.field1825) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method3295(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method3865(var10);
         }

         this.field1834[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LSequence;IIIB)V",
      garbageValue = "11"
   )
   static void method2326(Sequence var0, int var1, int var2, int var3) {
      if(Client.field542 < 50 && Client.field408 != 0) {
         if(var0.field1024 != null && var1 < var0.field1024.length) {
            int var4 = var0.field1024[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field543[Client.field542] = var5;
               Client.field544[Client.field542] = var6;
               Client.field545[Client.field542] = 0;
               Client.field554[Client.field542] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field546[Client.field542] = var7 + (var8 << 16) + (var9 << 8);
               ++Client.field542;
            }
         }
      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "421169603"
   )
   static void method2327(int var0, int var1) {
      class32 var2 = class8.field153;
      SecondaryBufferProvider.menuAction(var2.field739, var2.field733, var2.field732, var2.field736, var2.field735, var2.field735, var0, var1);
      class8.field153 = null;
   }
}
