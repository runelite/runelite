import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public final class class61 {
   @ObfuscatedName("i")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("j")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1347853047
   )
   static int field770;
   @ObfuscatedName("e")
   static final int[] field766;
   @ObfuscatedName("p")
   static final int[] field768;
   @ObfuscatedName("m")
   static final int[] field771;
   @ObfuscatedName("mo")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   static class157 field777;
   @ObfuscatedName("x")
   static final int[] field772;
   @ObfuscatedName("h")
   static final int[] field762;
   @ObfuscatedName("f")
   static final int[] field774;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1763996373
   )
   static int field775;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 316888691
   )
   static int field776;
   @ObfuscatedName("n")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("k")
   static int[][] field773;
   @ObfuscatedName("y")
   static int[] field769;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field770 = 99;
      field766 = new int[]{1, 2, 4, 8};
      field768 = new int[]{16, 32, 64, 128};
      field771 = new int[]{1, 0, -1, 0};
      field772 = new int[]{0, -1, 0, 1};
      field762 = new int[]{1, -1, -1, 1};
      field774 = new int[]{-1, -1, 1, 1};
      field775 = (int)(Math.random() * 17.0D) - 8;
      field776 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lip;",
      garbageValue = "2133926158"
   )
   public static class255 method1090(int var0) {
      class255 var1 = (class255)class255.field3413.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class255.field3419.getConfigData(32, var0);
         var1 = new class255();
         if(var2 != null) {
            var1.method4484(new Buffer(var2));
         }

         class255.field3413.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Ljf;",
      garbageValue = "75"
   )
   public static Overlay method1098(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1279875808"
   )
   static final void method1097(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class25.method210(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1224 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-17"
   )
   public static String method1100(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = Varbit.method4429(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
