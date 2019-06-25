import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("PlayerType")
public enum PlayerType implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("PlayerType_normal")
   PlayerType_normal(0, -1, true, false, true),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("PlayerType_playerModerator")
   PlayerType_playerModerator(1, 0, true, true, true),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("PlayerType_jagexModerator")
   PlayerType_jagexModerator(2, 1, true, true, false),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("PlayerType_ironman")
   PlayerType_ironman(3, 2, false, false, true),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("PlayerType_ultimateIronman")
   PlayerType_ultimateIronman(4, 3, false, false, true),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("PlayerType_hardcoreIronman")
   PlayerType_hardcoreIronman(5, 10, false, false, true);
   @ObfuscatedName("ak")
   @Export("__ij_ak")
   static Image __ij_ak;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1999564657
   )
   @Export("id")
   final int id;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 613822977
   )
   @Export("modIcon")
   public final int modIcon;
   @ObfuscatedName("e")
   @Export("isPrivileged")
   public final boolean isPrivileged;
   @ObfuscatedName("x")
   @Export("isUser")
   public final boolean isUser;

   PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.id = var3;
      this.modIcon = var4;
      this.isPrivileged = var6;
      this.isUser = var7;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "300731074"
   )
   static void method4547(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.ids.length; ++var2) {
            var1.ids[var2] = -1;
            var1.quantities[var2] = 0;
         }

      }
   }
}
