import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   @Export("definition")
   NPCDefinition definition;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "306250019"
   )
   @Export("__m_162")
   final void __m_162(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.sequence != -1 && WorldMapAreaData.getSequenceDefinition(super.sequence).__s == 1) {
         super.sequence = -1;
      }

      if(super.pathLength < 9) {
         ++super.pathLength;
      }

      for(int var5 = super.pathLength; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.pathTraversed[0] = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1647134110"
   )
   @Export("__f_163")
   final void __f_163(int var1, int var2, boolean var3) {
      if(super.sequence != -1 && WorldMapAreaData.getSequenceDefinition(super.sequence).__s == 1) {
         super.sequence = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.pathLength < 9) {
               ++super.pathLength;
            }

            for(int var6 = super.pathLength; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.pathTraversed[0] = 1;
            return;
         }
      }

      super.pathLength = 0;
      super.__ch = 0;
      super.__cq = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.size * 64 + super.pathX[0] * 128;
      super.y = super.size * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ldu;",
      garbageValue = "-2134947096"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.definition == null) {
         return null;
      } else {
         SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0?WorldMapAreaData.getSequenceDefinition(super.sequence):null;
         SequenceDefinition var2 = super.movementSequence == -1 || super.movementSequence == super.idleSequence && var1 != null?null:WorldMapAreaData.getSequenceDefinition(super.movementSequence);
         Model var3 = this.definition.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.defaultHeight = var3.height;
            if(super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
               Model var4 = class50.getSpotAnimationDefinition(super.spotAnimation).getModel(super.spotAnimationFrame);
               if(var4 != null) {
                  var4.offsetBy(0, -super.heightOffset, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.definition.size == 1) {
               var3.isSingleTile = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   final boolean isVisible() {
      return this.definition != null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILff;Lit;B)V",
      garbageValue = "-51"
   )
   static void method2009(int var0, IndexStore var1, IndexCache var2) {
      IndexStoreAction var3 = new IndexStoreAction();
      var3.type = 1;
      var3.key = (long)var0;
      var3.indexStore = var1;
      var3.indexCache = var2;
      NodeDeque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      NodeDeque var5 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFirst(var3);
      }

      Object var10 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      Object var6 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.__iv_q == 0) {
            Frames.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            Frames.IndexStoreActionHandler_thread.setDaemon(true);
            Frames.IndexStoreActionHandler_thread.start();
            Frames.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.__iv_q = 600;
      }
   }
}
