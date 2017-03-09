import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("qr")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("x")
   Frame[] field1580;
   @ObfuscatedName("q")
   static int[] field1582;
   @ObfuscatedName("es")
   static SpritePixels field1583;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "958404458"
   )
   public boolean method1956(int var1) {
      return this.field1580[var1].field1337;
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)Ljava/lang/String;",
      garbageValue = "62"
   )
   static String method1962(Widget var0, int var1) {
      return !class97.method1989(class174.method3271(var0), var1) && null == var0.field2286?null:(null != var0.actions && var0.actions.length > var1 && null != var0.actions[var1] && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass18;I)V",
      garbageValue = "1810404102"
   )
   static void method1963(class18 var0) {
      Player.method271(var0, 200000);
   }

   Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3316(var3);
      this.field1580 = new Frame[var6];
      int[] var7 = var1.method3313(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2448(); null != var12; var12 = (FrameMap)var5.method2445()) {
            if(var11 == var12.field1485) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3312(0, var11);
            } else {
               var13 = var2.method3312(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method2458(var10);
         }

         this.field1580[var7[var8]] = new Frame(var9, var10);
      }

   }
}
