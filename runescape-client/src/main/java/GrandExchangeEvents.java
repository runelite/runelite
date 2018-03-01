import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
   @ObfuscatedName("z")
   public static Comparator field284;
   @ObfuscatedName("n")
   public static Comparator field283;
   @ObfuscatedName("r")
   public static Comparator field286;
   @ObfuscatedName("e")
   public static Comparator field285;
   @ObfuscatedName("t")
   public static boolean field281;
   @ObfuscatedName("d")
   @Export("events")
   public final List events;

   static {
      field284 = new class19();
      new WorldComparator();
      field283 = new UnitPriceComparator();
      field286 = new class18();
      field285 = new TotalQuantityComparator();
   }

   @ObfuscatedSignature(
      signature = "(Lgy;Z)V",
      garbageValue = "1"
   )
   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.events = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZB)V",
      garbageValue = "13"
   )
   @Export("sort")
   public void sort(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "47"
   )
   static void method79() {
      class265.field3425 = new int[2000];
      int var0 = 0;
      int var1 = 240;

      int var3;
      for(byte var2 = 12; var0 < 16; var1 -= var2) {
         var3 = GraphicsObject.method1845((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)((float)var0 * 0.425F / 16.0F + 0.075F));
         class265.field3425[var0] = var3;
         ++var0;
      }

      var1 = 48;

      for(int var5 = var1 / 6; var0 < class265.field3425.length; var1 -= var5) {
         var3 = var0 * 2;

         for(int var4 = GraphicsObject.method1845((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < class265.field3425.length; ++var0) {
            class265.field3425[var0] = var4;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1618093607"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.listFetcher == null) {
            World.listFetcher = class45.urlRequester.request(new URL(class49.field613));
         } else if(World.listFetcher.isDone()) {
            byte[] var0 = World.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            World.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = World.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            Tile.method2753(World.worldList, 0, World.worldList.length - 1, World.field1209, World.field1211);
            World.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-505410702"
   )
   static final void method80() {
      Client.field899.close();
      Overlay.overlays.reset();
      class149.method3194();
      class229.method4237();
      ObjectComposition.objects.reset();
      ObjectComposition.field3591.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3593.reset();
      IndexDataBase.method4761();
      class20.method152();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      class196.method3831();
      IndexFile.method3416();
      VarPlayerType.varplayers.reset();
      class281.field3565.reset();
      class281.field3566.reset();
      class281.field3567.reset();
      class178.method3472();
      class279.field3548.reset();
      class278.field3541.reset();
      GraphicsObject.method1847();
      GameCanvas.method799();
      Widget.field2819.reset();
      Widget.Widget_cachedModels.reset();
      Widget.Widget_cachedFonts.reset();
      Widget.field2822.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1439.reset();
      class21.indexInterfaces.reset();
      class5.indexSoundEffects.reset();
      class195.indexCache3.reset();
      class178.indexCache4.reset();
      BuildType.indexMaps.reset();
      class154.indexTrack1.reset();
      Client.indexModels.reset();
      Renderable.indexSprites.reset();
      class86.indexTextures.reset();
      GrandExchangeOffer.indexCache10.reset();
      class66.indexTrack2.reset();
      class1.indexScripts.reset();
      class86.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class229.field2694 = 1;
      class229.field2687 = null;
      class229.field2691 = -1;
      AttackOption.field1331 = -1;
      class229.field2692 = 0;
      class37.field506 = false;
      class284.field3699 = 2;
      Client.field1115 = -1;
      Client.field970 = false;
      class5.method16();
      Enum.setGameState(10);
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(Liw;IIIIIII)V",
      garbageValue = "311947002"
   )
   static final void method81(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field1024) {
         Client.field920 = 32;
      } else {
         Client.field920 = 0;
      }

      Client.field1024 = false;
      int var7;
      if(MouseInput.mouseCurrentButton == 1 || !Enum.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class171.method3363(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class171.method3363(var0);
         } else if(var5 >= var1 - Client.field920 && var5 < Client.field920 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class171.method3363(var0);
            Client.field1024 = true;
         }
      }

      if(Client.mouseWheelRotation != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.mouseWheelRotation * 45;
            class171.method3363(var0);
         }
      }

   }
}
