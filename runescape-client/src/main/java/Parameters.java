import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("Parameters")
public class Parameters {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3714;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3705;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3713;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3703;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3701;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3708;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3704;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3707;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   public static final Parameters field3712;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3706;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3710;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   public static final Parameters field3715;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3709;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3711;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static final Parameters field3700;
   @ObfuscatedName("e")
   @Export("key")
   public final String key;

   static {
      field3714 = new Parameters("1", "1");
      field3713 = new Parameters("13", "13");
      field3703 = new Parameters("2", "2");
      field3708 = new Parameters("15", "15");
      field3701 = new Parameters("10", "10");
      field3705 = new Parameters("12", "12");
      field3706 = new Parameters("4", "4");
      field3707 = new Parameters("7", "7");
      field3700 = new Parameters("8", "8");
      field3709 = new Parameters("5", "5");
      field3710 = new Parameters("14", "14");
      field3711 = new Parameters("9", "9");
      field3712 = new Parameters("11", "11");
      field3715 = new Parameters("3", "3");
      field3704 = new Parameters("6", "6");
   }

   Parameters(String var1, String var2) {
      this.key = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lia;III)[Lkp;",
      garbageValue = "2049363802"
   )
   static SpritePixels[] method4934(IndexDataBase var0, int var1, int var2) {
      if(!FileOnDisk.method2386(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels[] var4 = new SpritePixels[class287.field3780];

         for(int var5 = 0; var5 < class287.field3780; ++var5) {
            SpritePixels var6 = var4[var5] = new SpritePixels();
            var6.maxWidth = class287.field3779;
            var6.maxHeight = ISAACCipher.field2435;
            var6.offsetX = class287.field3781[var5];
            var6.offsetY = class211.offsetsY[var5];
            var6.width = class266.field3647[var5];
            var6.height = class287.field3782[var5];
            int var7 = var6.height * var6.width;
            byte[] var8 = class274.spritePixels[var5];
            var6.image = new int[var7];

            for(int var9 = 0; var9 < var7; ++var9) {
               var6.image[var9] = class287.field3783[var8[var9] & 255];
            }
         }

         class287.field3781 = null;
         class211.offsetsY = null;
         class266.field3647 = null;
         class287.field3782 = null;
         class287.field3783 = null;
         class274.spritePixels = null;
         return var4;
      }
   }
}
