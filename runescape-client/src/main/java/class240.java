import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
public class class240 extends CacheableNode {
   @ObfuscatedName("i")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("m")
   public static NodeCache field3286;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -434038259
   )
   public int field3287;
   @ObfuscatedName("p")
   public static IndexDataBase field3288;

   public class240() {
      this.field3287 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1155564150"
   )
   void method4145(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3287 = var1.readUnsignedShort();
      }

   }

   static {
      field3286 = new NodeCache(64);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-965152648"
   )
   public void method4152(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4145(var1, var2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILCoordinates;ZI)V",
      garbageValue = "-942759661"
   )
   static void method4157(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = WidgetNode.method1030().method5151(var0);
      int var4 = class20.localPlayer.field884;
      int var5 = (class20.localPlayer.x >> 7) + class19.baseX;
      int var6 = (class20.localPlayer.y >> 7) + class21.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      WidgetNode.method1030().method5207(var3, var7, var1, var2);
   }
}
