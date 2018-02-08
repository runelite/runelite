import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class35 {
   @ObfuscatedName("pk")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   @Export("friendManager")
   public static FriendManager friendManager;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   static final class35 field477;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   static final class35 field476;
   @ObfuscatedName("d")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("y")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1058422263
   )
   final int field470;

   static {
      field477 = new class35(0);
      field476 = new class35(1);
   }

   class35(int var1) {
      this.field470 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lir;III)Z",
      garbageValue = "1314691064"
   )
   public static boolean method484(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class3.decodeSprite(var3);
         return true;
      }
   }
}
