import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class204 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1831435129
   )
   public static int field2507;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   public static class111 field2511;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field2508;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1334127079
   )
   static int field2509;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field2506;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field2512;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field2504;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static IndexDataBase field2513;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 972950323
   )
   static int field2510;

   static {
      field2507 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1098917158"
   )
   static void method3749() {
      for(class81 var0 = (class81)class81.field1334.getFront(); var0 != null; var0 = (class81)class81.field1334.getNext()) {
         if(var0.field1327 != null) {
            class33.field479.method1880(var0.field1327);
            var0.field1327 = null;
         }

         if(var0.field1338 != null) {
            class33.field479.method1880(var0.field1338);
            var0.field1338 = null;
         }
      }

      class81.field1334.clear();
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-256"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class27.plane][var0][var1];
      if(var2 == null) {
         ScriptState.region.method2733(class27.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class169.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            ScriptState.region.method2733(class27.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            ScriptState.region.addItemPile(class27.plane, var0, var1, class227.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class27.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Liv;",
      garbageValue = "1553752238"
   )
   public static Enum method3764(int var0) {
      Enum var1 = (Enum)Enum.field3401.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.field3410.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.field3401.put(var1, (long)var0);
         return var1;
      }
   }
}
