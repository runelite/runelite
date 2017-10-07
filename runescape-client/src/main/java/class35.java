import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class35 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   static final class35 field515;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public static Track1 field516;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   static final class35 field512;
   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "[Lkr;"
   )
   @Export("hitmarks")
   static SpritePixels[] hitmarks;
   @ObfuscatedName("y")
   @Export("blendedSaturation")
   static int[] blendedSaturation;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = -592287183
   )
   static int field514;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 739740017
   )
   final int field513;

   static {
      field515 = new class35(0);
      field512 = new class35(1);
   }

   class35(int var1) {
      this.field513 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-2127264624"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + PlayerComposition.method4079(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lit;II)Z",
      garbageValue = "-459196987"
   )
   public static boolean method484(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4224(var1);
      if(var2 == null) {
         return false;
      } else {
         Timer.decodeSprite(var2);
         return true;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-1399316640"
   )
   static int method485(int var0, Script var1, boolean var2) {
      Widget var3 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
      if(var0 == 2500) {
         class81.intStack[++class81.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class81.intStack[++class81.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class81.intStack[++class81.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class81.intStack[++class81.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class81.intStack[++class81.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class81.intStack[++class81.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
