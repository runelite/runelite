import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class7 {
   @ObfuscatedName("w")
   public static boolean field245;
   @ObfuscatedName("s")
   public static boolean field238;
   @ObfuscatedName("q")
   public static boolean field247;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static class11 field240;
   @ObfuscatedName("cr")
   static boolean field244;
   @ObfuscatedName("an")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static CombatInfoList field241;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      longValue = 5050311703199981383L
   )
   static long field243;
   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   static class262 field246;
   @ObfuscatedName("e")
   static byte[][][] field248;

   static {
      field245 = false;
      field238 = false;
      field247 = false;
      field240 = class11.field276;
      field241 = new CombatInfoList();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Leo;",
      garbageValue = "-1548337777"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         IndexDataBase var3 = Sequence.skel_ref;
         IndexDataBase var4 = Sequence.skin_ref;
         boolean var5 = true;
         int[] var6 = var3.getChilds(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.getChild(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.getChild(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(var2 != null) {
            Sequence.skeletons.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1494717784"
   )
   static final void method33() {
      int[] var0 = class94.playerIndices;

      int var1;
      for(var1 = 0; var1 < class94.playerIndexesCount; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.field1225 > 0) {
            --var2.field1225;
            if(var2.field1225 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.field1225 > 0) {
            --var3.field1225;
            if(var3.field1225 == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
