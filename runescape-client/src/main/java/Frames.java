import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("q")
   Frame[] field1579;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 1011561167
   )
   static int field1580;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "72240421"
   )
   public static ModIcon[] method1957(class182 var0, String var1, String var2) {
      int var3 = var0.method3335(var1);
      int var4 = var0.method3319(var3, var2);
      return class94.method1977(var0, var3, var4);
   }

   Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3313(var3);
      this.field1579 = new Frame[var6];
      int[] var7 = var1.method3312(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2458(); null != var12; var12 = (FrameMap)var5.method2472()) {
            if(var11 == var12.field1483) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3365(0, var11);
            } else {
               var13 = var2.method3365(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method2453(var10);
         }

         this.field1579[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SB)V",
      garbageValue = "-45"
   )
   public static void method1961(String[] var0, short[] var1) {
      MessageNode.method214(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1503660124"
   )
   public boolean method1962(int var1) {
      return this.field1579[var1].field1346;
   }
}
