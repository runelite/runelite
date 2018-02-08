import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("i")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1872728409
   )
   @Export("ordinal")
   final int ordinal;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.ordinal = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-1025439051"
   )
   public static int method4487(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lir;II)Lkh;",
      garbageValue = "-404771081"
   )
   public static IndexedSprite method4491(IndexDataBase var0, int var1) {
      return !class274.method5158(var0, var1)?null:class89.method1909();
   }
}
