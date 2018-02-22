import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 898317951
   )
   static int field1425;
   @ObfuscatedName("ah")
   static int[] field1422;
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 977706959
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -468508935
   )
   @Export("type")
   int type;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1768872327
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -143561081
   )
   @Export("level")
   int level;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2085338663
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -808855453
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   Sequence field1419;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1199830183
   )
   int field1423;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 897719287
   )
   int field1421;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLes;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1419 = Occluder.getAnimation(var7);
         this.field1423 = 0;
         this.field1421 = Client.gameCycle - 1;
         if(this.field1419.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1419 == this.field1419) {
               this.field1423 = var10.field1423;
               this.field1421 = var10.field1421;
               return;
            }
         }

         if(var8 && this.field1419.frameStep != -1) {
            this.field1423 = (int)(Math.random() * (double)this.field1419.frameIDs.length);
            this.field1421 -= (int)(Math.random() * (double)this.field1419.frameLenghts[this.field1423]);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "582025400"
   )
   protected final Model getModel() {
      if(this.field1419 != null) {
         int var1 = Client.gameCycle - this.field1421;
         if(var1 > 100 && this.field1419.frameStep > 0) {
            var1 = 100;
         }

         label56: {
            do {
               do {
                  if(var1 <= this.field1419.frameLenghts[this.field1423]) {
                     break label56;
                  }

                  var1 -= this.field1419.frameLenghts[this.field1423];
                  ++this.field1423;
               } while(this.field1423 < this.field1419.frameIDs.length);

               this.field1423 -= this.field1419.frameStep;
            } while(this.field1423 >= 0 && this.field1423 < this.field1419.frameIDs.length);

            this.field1419 = null;
         }

         this.field1421 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = Preferences.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.width;
            var3 = var12.length;
         } else {
            var2 = var12.length;
            var3 = var12.width;
         }

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var5][var6] + var8[var4][var6] + var8[var4][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4958(this.type, this.orientation, var8, var10, var9, var11, this.field1419, this.field1423);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILiu;S)I",
      garbageValue = "2577"
   )
   public static int method2013(int var0, class239 var1) {
      return (var0 + 40000 << 8) + var1.field2917;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lia;IIIBZI)V",
      garbageValue = "672852909"
   )
   @Export("requestNetFile")
   static void requestNetFile(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class258.NetCache_pendingPriorityWrites.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class258.NetCache_pendingPriorityResponses.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class258.NetCache_pendingWrites.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class258.NetCache_pendingPriorityWrites.put(var8, var6);
                  --class258.NetCache_pendingWritesCount;
                  ++class258.NetCache_pendingPriorityWritesCount;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class258.NetCache_pendingResponses.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class258.NetCache_pendingPriorityWrites.put(var8, var6);
                  ++class258.NetCache_pendingPriorityWritesCount;
               } else {
                  class258.NetCache_pendingWritesQueue.push(var8);
                  class258.NetCache_pendingWrites.put(var8, var6);
                  ++class258.NetCache_pendingWritesCount;
               }

            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "-1885914111"
   )
   static int method2009(int var0, Script var1, boolean var2) {
      Widget var3 = NetWriter.getWidget(class80.intStack[--class80.intStackSize]);
      if(var0 == 2800) {
         class80.intStack[++class80.intStackSize - 1] = class89.method1879(class230.getWidgetConfig(var3));
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
            } else {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class80.intStack[--class80.intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lff;IIB)Ldw;",
      garbageValue = "0"
   )
   public static final AbstractSoundSystem method2015(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = AbstractSoundSystem.soundTaskDataProvider.taskData();
            var3.samples = new int[(Frames.audioHighMemory?2:1) * 256];
            var3.field1519 = var2;
            var3.vmethod2209();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(BoundingBox.priority > 0 && BoundingBox2D.task == null) {
               BoundingBox2D.task = new SoundTask();
               class40.field505 = Executors.newScheduledThreadPool(1);
               class40.field505.scheduleAtFixedRate(BoundingBox2D.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(BoundingBox2D.task != null) {
               if(BoundingBox2D.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               BoundingBox2D.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Lim;I)Lim;",
      garbageValue = "-850550064"
   )
   static Widget method2012(Widget var0) {
      Widget var2 = var0;
      int var4 = class230.getWidgetConfig(var0);
      int var3 = var4 >> 17 & 7;
      int var5 = var3;
      Widget var1;
      if(var3 == 0) {
         var1 = null;
      } else {
         int var6 = 0;

         while(true) {
            if(var6 >= var5) {
               var1 = var2;
               break;
            }

            var2 = NetWriter.getWidget(var2.parentId);
            if(var2 == null) {
               var1 = null;
               break;
            }

            ++var6;
         }
      }

      Widget var7 = var1;
      if(var1 == null) {
         var7 = var0.dragParent;
      }

      return var7;
   }
}
