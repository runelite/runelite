import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public abstract class class156 {
   @ObfuscatedName("c")
   static boolean field2125 = false;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1837900718"
   )
   static final void method2929() {
      class185.method3319();
      class165.method3037();
      class146.method2658();
      ObjectComposition.field2931.reset();
      ObjectComposition.field2902.reset();
      ObjectComposition.field2903.reset();
      ObjectComposition.field2940.reset();
      NPCComposition.field3006.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.field2986.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      FloorUnderlayDefinition.method3381();
      class18.method160();
      Tile.method1516();
      Buffer.method2919();
      class196.field2875.reset();
      class196.spriteCache.reset();
      class196.field2877.reset();
      class32.method665();
      class157.method2950();
      class101.method1902();
      ((TextureProvider)class84.field1438).method1404();
      class48.field938.reset();
      class8.field86.method3195();
      class37.field780.method3195();
      XClanMember.field288.method3195();
      class5.field60.method3195();
      class1.field16.method3195();
      class164.field2170.method3195();
      class97.field1639.method3195();
      class40.field807.method3195();
      Client.field324.method3195();
      class108.field1736.method3195();
      Client.field325.method3195();
      WidgetNode.field201.method3195();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-12"
   )
   abstract void vmethod2930(byte[] var1);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-65"
   )
   abstract byte[] vmethod2931();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)LMessageNode;",
      garbageValue = "1197386683"
   )
   static MessageNode method2933(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var2.method858(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-134420726"
   )
   static char method2942(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1084313003"
   )
   static void method2944(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = class214.method3827(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class214.method3827(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method2944(var0, var7 - 1, var2, var3, var4, var5);
         method2944(1 + var7, var1, var2, var3, var4, var5);
      }

   }
}
