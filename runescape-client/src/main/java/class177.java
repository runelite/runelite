import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class177 {
   @ObfuscatedName("b")
   public static int[][] field2266;
   @ObfuscatedName("z")
   public static int[][] field2264;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2059955951
   )
   public static int field2268;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -921454579
   )
   public static int field2271;
   @ObfuscatedName("y")
   public static int[] field2270;
   @ObfuscatedName("c")
   public static int[] field2269;

   static {
      field2266 = new int[128][128];
      field2264 = new int[128][128];
      field2270 = new int[4096];
      field2269 = new int[4096];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILjs;II)V",
      garbageValue = "-536154017"
   )
   static void method3494(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class80 var5 = new class80();
      var5.field1243 = var0;
      var5.field1245 = var1 * 128;
      var5.field1246 = var2 * 128;
      int var6 = var3.width;
      int var7 = var3.length;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.length;
         var7 = var3.width;
      }

      var5.field1253 = (var6 + var1) * 128;
      var5.field1250 = (var7 + var2) * 128;
      var5.field1248 = var3.ambientSoundId;
      var5.field1249 = var3.int4 * 128;
      var5.field1252 = var3.int5;
      var5.field1256 = var3.int6;
      var5.field1254 = var3.field3639;
      if(var3.impostorIds != null) {
         var5.field1257 = var3;
         var5.method1845();
      }

      class80.field1247.addFront(var5);
      if(var5.field1254 != null) {
         var5.field1255 = var5.field1252 + (int)(Math.random() * (double)(var5.field1256 - var5.field1252));
      }

   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1899891882"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[ScriptVarType.plane][var0][var1];
      if(var2 == null) {
         GameSocket.region.removeGroundItemPile(ScriptVarType.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = NetWriter.getItemDefinition(var6.id);
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
            GameSocket.region.removeGroundItemPile(ScriptVarType.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            GameSocket.region.addItemPile(ScriptVarType.plane, var0, var1, GrandExchangeEvent.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, ScriptVarType.plane), var5, var9, var11, var10);
         }
      }
   }
}
