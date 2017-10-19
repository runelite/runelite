import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -685539711
   )
   static int field825;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = -1017991757
   )
   static int field824;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1781525527
   )
   @Export("world")
   int world;
   @ObfuscatedName("g")
   boolean field819;
   @ObfuscatedName("v")
   boolean field820;
   @ObfuscatedName("w")
   @Export("name")
   String name;
   @ObfuscatedName("s")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 757368741
   )
   @Export("rank")
   int rank;

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-63"
   )
   static final void method1083(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class48.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.field757, MouseInput.field758);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lil;",
      garbageValue = "-1762005639"
   )
   public static VarPlayerType method1084(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }
}
