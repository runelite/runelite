import java.net.URL;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class12 implements Comparator {
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "Ljb;"
   )
   public static BufferProvider field275;
   @ObfuscatedName("fo")
   static byte[][] field277;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lb;Lb;I)I",
      garbageValue = "-2051446698"
   )
   int method69(class14 var1, class14 var2) {
      return var1.field297 < var2.field297?-1:(var2.field297 == var1.field297?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method69((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Liz;",
      garbageValue = "43"
   )
   public static CombatInfo2 method72(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3362.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field3366.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method4487(new Buffer(var2));
         }

         CombatInfo2.field3362.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1134027313"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class266.field3665[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "21"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.listFetcher == null) {
            World.listFetcher = class66.field832.method2969(new URL(DState.field2392));
         } else if(World.listFetcher.method2990()) {
            byte[] var0 = World.listFetcher.method2984();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            class138.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = class138.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            class110.method2174(class138.worldList, 0, class138.worldList.length - 1, World.field1280, World.field1285);
            World.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.listFetcher = null;
      }

      return false;
   }
}
