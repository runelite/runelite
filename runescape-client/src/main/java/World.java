import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("World")
public class World {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 783964909
   )
   @Export("index")
   int index;
   @ObfuscatedName("n")
   static int[] field669 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 715696617
   )
   static int field670 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -853949669
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @Export("address")
   String address;
   @ObfuscatedName("c")
   @Export("worldServersDownload")
   static class26 worldServersDownload;
   @ObfuscatedName("d")
   static int[] field674 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1101249857
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1596318049
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1701014639
   )
   static int field677 = 0;
   @ObfuscatedName("a")
   @Export("activity")
   String activity;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1694899467
   )
   @Export("location")
   int location;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "5"
   )
   boolean method652() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1284806634"
   )
   boolean method654() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "410844093"
   )
   boolean method655() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1548893735"
   )
   boolean method657() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "33"
   )
   boolean method661() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "30877"
   )
   boolean method678() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-1330047170"
   )
   public static byte[] method682(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class163) {
         class163 var2 = (class163)var0;
         return var2.vmethod3147();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
