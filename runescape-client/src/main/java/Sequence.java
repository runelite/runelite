import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1361174265
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("k")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("d")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 492094891
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -639250131
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("z")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("o")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1510929283
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1625798861
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("v")
   int[] field3610;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1873294377
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -333633271
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1616945333
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("r")
   public int[] field3599;

   static {
      sequences = new NodeCache(64);
      skeletons = new NodeCache(100);
   }

   Sequence() {
      this.frameStep = -1;
      this.stretches = false;
      this.forcedPriority = 5;
      this.leftHandItem = -1;
      this.rightHandItem = -1;
      this.maxLoops = 99;
      this.precedenceAnimating = -1;
      this.priority = -1;
      this.replyMode = 2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;II)V",
      garbageValue = "21332216"
   )
   void method4713(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLenghts = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLenghts[var4] = var1.readUnsignedShort();
         }

         this.frameIDs = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 2) {
         this.frameStep = var1.readUnsignedShort();
      } else if(var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.readUnsignedByte();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.forcedPriority = var1.readUnsignedByte();
      } else if(var2 == 6) {
         this.leftHandItem = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.rightHandItem = var1.readUnsignedShort();
      } else if(var2 == 8) {
         this.maxLoops = var1.readUnsignedByte();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.readUnsignedByte();
      } else if(var2 == 10) {
         this.priority = var1.readUnsignedByte();
      } else if(var2 == 11) {
         this.replyMode = var1.readUnsignedByte();
      } else if(var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.field3610 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3610[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3610[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3599 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3599[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lew;II)Lew;",
      garbageValue = "-749457419"
   )
   public Model method4715(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = ItemComposition.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2608(true);
      } else {
         Model var4 = var1.method2608(!var3.method2912(var2));
         var4.method2523(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lew;ILjd;II)Lew;",
      garbageValue = "-290989549"
   )
   public Model method4718(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = ItemComposition.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4715(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = ItemComposition.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2608(!var5.method2912(var2));
            var7.method2523(var5, var2);
            return var7;
         } else {
            var7 = var1.method2608(!var5.method2912(var2) & !var6.method2912(var4));
            var7.method2524(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lew;IIS)Lew;",
      garbageValue = "1337"
   )
   Model method4740(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = ItemComposition.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2608(true);
      } else {
         Model var5 = var1.method2608(!var4.method2912(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2528();
         } else if(var3 == 2) {
            var5.method2514();
         } else if(var3 == 3) {
            var5.method2556();
         }

         var5.method2523(var4, var2);
         if(var3 == 1) {
            var5.method2556();
         } else if(var3 == 2) {
            var5.method2514();
         } else if(var3 == 3) {
            var5.method2528();
         }

         return var5;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lew;II)Lew;",
      garbageValue = "2028722867"
   )
   Model method4717(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = ItemComposition.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2554(true);
      } else {
         Model var4 = var1.method2554(!var3.method2912(var2));
         var4.method2523(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lew;II)Lew;",
      garbageValue = "1491653818"
   )
   public Model method4719(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = ItemComposition.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2608(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3610 != null && var2 < this.field3610.length) {
            var6 = this.field3610[var2];
            var5 = ItemComposition.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2608(!var4.method2912(var3) & !var5.method2912(var6));
            var7.method2523(var4, var3);
            var7.method2523(var5, var6);
            return var7;
         } else {
            var7 = var1.method2608(!var4.method2912(var3));
            var7.method2523(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   @Export("post")
   void post() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.priority == -1) {
         if(this.interleaveLeave != null) {
            this.priority = 2;
         } else {
            this.priority = 0;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "2062913022"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4713(var1, var2);
      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "66"
   )
   static final void method4745(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
         Overlay.method4710(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1194 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
