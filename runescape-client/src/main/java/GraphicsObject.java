import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1586831759
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2112458717
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -964622773
   )
   @Export("level")
   int level;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1367517275
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -943669317
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 673539369
   )
   @Export("height")
   int height;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   Sequence field1241;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1203290467
   )
   int field1245;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1607133215
   )
   int field1243;
   @ObfuscatedName("h")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1245 = 0;
      this.field1243 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = GrandExchangeEvents.getSpotAnimType(this.id).field3395;
      if(var8 != -1) {
         this.finished = false;
         this.field1241 = CacheFile.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   final void method1798(int var1) {
      if(!this.finished) {
         this.field1243 += var1;

         while(this.field1243 > this.field1241.frameLenghts[this.field1245]) {
            this.field1243 -= this.field1241.frameLenghts[this.field1245];
            ++this.field1245;
            if(this.field1245 >= this.field1241.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-2096748380"
   )
   protected final Model getModel() {
      Spotanim var1 = GrandExchangeEvents.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1245);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-1896008353"
   )
   static final void method1805(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         KeyFocusListener.method760(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1091 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Lbe;ZS)V",
      garbageValue = "2983"
   )
   static final void method1797(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class3.method9(var2);
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetFlags.first(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.next()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var6 = class35.getWidget(var3);
      if(var6 != null) {
         class60.method1015(var6);
      }

      BoundingBox2D.method55();
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class213.loadWidget(var5)) {
            Overlay.method4945(FileRequest.widgets[var5], 1);
         }
      }

   }
}
