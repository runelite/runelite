import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("skel_ref")
   static IndexDataBase skel_ref;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("skin_ref")
   static IndexDataBase skin_ref;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("seq_ref")
   static IndexDataBase seq_ref;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1472811703
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("m")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("r")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1994708671
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -925375157
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("x")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("w")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 173690615
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 3182249
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("s")
   int[] field3584;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -862219575
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 669806119
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1355898089
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("p")
   public int[] field3586;

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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "2043332425"
   )
   void method4581(Buffer var1, int var2) {
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
         this.field3584 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3584[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3584[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3586 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3586[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Leo;II)Leo;",
      garbageValue = "-638740314"
   )
   public Model method4583(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = Area.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2429(true);
      } else {
         Model var4 = var1.method2429(!var3.method2810(var2));
         var4.method2437(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Leo;ILjc;II)Leo;",
      garbageValue = "-852822549"
   )
   public Model method4582(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = Area.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4583(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = Area.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2429(!var5.method2810(var2));
            var7.method2437(var5, var2);
            return var7;
         } else {
            var7 = var1.method2429(!var5.method2810(var2) & !var6.method2810(var4));
            var7.method2485(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Leo;III)Leo;",
      garbageValue = "-2132974939"
   )
   Model method4580(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = Area.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2429(true);
      } else {
         Model var5 = var1.method2429(!var4.method2810(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2472();
         } else if(var3 == 2) {
            var5.method2440();
         } else if(var3 == 3) {
            var5.method2439();
         }

         var5.method2437(var4, var2);
         if(var3 == 1) {
            var5.method2439();
         } else if(var3 == 2) {
            var5.method2440();
         } else if(var3 == 3) {
            var5.method2472();
         }

         return var5;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Leo;II)Leo;",
      garbageValue = "1201607337"
   )
   Model method4595(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = Area.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2430(true);
      } else {
         Model var4 = var1.method2430(!var3.method2810(var2));
         var4.method2437(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Leo;II)Leo;",
      garbageValue = "-1306736566"
   )
   public Model method4585(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = Area.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2429(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3584 != null && var2 < this.field3584.length) {
            var6 = this.field3584[var2];
            var5 = Area.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2429(!var4.method2810(var3) & !var5.method2810(var6));
            var7.method2437(var4, var3);
            var7.method2437(var5, var6);
            return var7;
         } else {
            var7 = var1.method2429(!var4.method2810(var3));
            var7.method2437(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "0"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4581(var1, var2);
      }
   }
}
