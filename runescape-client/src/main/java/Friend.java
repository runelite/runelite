import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("i")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 911213343
   )
   @Export("world")
   int world;
   @ObfuscatedName("o")
   boolean field156;
   @ObfuscatedName("r")
   boolean field157;
   @ObfuscatedName("g")
   static int[] field158;
   @ObfuscatedName("c")
   static int[] field159;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 1256879615
   )
   static int field161;
   @ObfuscatedName("bv")
   static IndexData field162;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1782080583
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("f")
   @Export("name")
   String name;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1037228149"
   )
   public static void method162() {
      try {
         class104.field1713.method1435();

         for(int var0 = 0; var0 < class0.field3; ++var0) {
            WidgetNode.field186[var0].method1435();
         }

         class104.field1714.method1435();
         class104.field1712.method1435();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "1305341676"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3058.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3061.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method3786(new Buffer(var2));
         }

         var1.method3788();
         Sequence.field3058.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "1914941195"
   )
   static void method164(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         class177.method3315(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "1284003583"
   )
   static void method165(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field652 = 0;
            var0.actionAnimationDisable = var2;
            var0.field637 = 0;
         }

         if(var3 == 2) {
            var0.field637 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || getAnimation(var1).forcedPriority >= getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field652 = 0;
         var0.actionAnimationDisable = var2;
         var0.field637 = 0;
         var0.field655 = var0.field672;
      }

   }
}
