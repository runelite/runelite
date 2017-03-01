import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1469480861
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("y")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 658574939
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1149067973
   )
   @Export("y")
   int y;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1230146569
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -92870509
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2146734301
   )
   int field1623;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -535631025
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -143687021
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1311230121
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -247070903
   )
   int field1628;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1474643199
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 105178171
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -351413359
   )
   @Export("height")
   int height;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1294833617"
   )
   public static int method2019(CharSequence var0) {
      return class31.method718(var0, 10, true);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)LFrames;",
      garbageValue = "69"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3064.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         class182 var3 = class203.field3085;
         class182 var4 = Sequence.field3059;
         boolean var5 = true;
         int[] var6 = var3.method3364(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3361(var0, var6[var7]);
            if(null == var8) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3361(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(var2 != null) {
            Sequence.field3064.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1623311979"
   )
   static final void method2021() {
      if(Client.field342 > 0) {
         class33.method773();
      } else {
         World.setGameState(40);
         class22.field236 = XGrandExchangeOffer.field30;
         XGrandExchangeOffer.field30 = null;
      }
   }
}
