import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class45 extends WorldMapData {
   @ObfuscatedName("mb")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   @Export("mouseWheel")
   static MouseWheel mouseWheel;
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("c")
   HashSet field556;
   @ObfuscatedName("v")
   HashSet field555;
   @ObfuscatedName("u")
   List field554;

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(Lgb;Lgb;Lgb;IZI)V",
      garbageValue = "-1670821459"
   )
   void method682(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field556 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method176(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field556.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field555 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class46 var9 = new class46();

         try {
            var9.method695(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field555.add(var9);
      }

      this.method683(var2, var5);
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(Lgb;ZI)V",
      garbageValue = "975435623"
   )
   void method683(Buffer var1, boolean var2) {
      this.field554 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3553();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field554.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "196572852"
   )
   static final void method687() {
      MapIconReference.method757("Your friend list is full. Max of 200 for free users, and 400 for members");
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lbd;I)V",
      garbageValue = "1728686707"
   )
   @Export("changeWorld")
   static void changeWorld(World var0) {
      if(var0.method1690() != Client.isMembers) {
         Client.isMembers = var0.method1690();
         class240.method4449(var0.method1690());
      }

      GrandExchangeEvent.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class110.port1 = Client.socketType == 0?43594:var0.id + 40000;
      Player.port2 = Client.socketType == 0?443:var0.id + 50000;
      class85.myWorldPort = class110.port1;
   }
}
