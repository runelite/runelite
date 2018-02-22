import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("h")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("l")
   int[] field3678;
   @ObfuscatedName("y")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("g")
   public int[] field3686;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 313325961
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("u")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("r")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 861022745
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 86424661
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -609690011
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 518559797
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -684804059
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 953135201
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 255238625
   )
   @Export("replyMode")
   public int replyMode;

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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "376816564"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "-1932051116"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
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
         this.field3678 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3678[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3678[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3686 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3686[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lee;II)Lee;",
      garbageValue = "-1820727981"
   )
   public Model method5136(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class159.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2703(true);
      } else {
         Model var4 = var1.method2703(!var3.method3053(var2));
         var4.method2718(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lee;IIB)Lee;",
      garbageValue = "-4"
   )
   Model method5131(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class159.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2703(true);
      } else {
         Model var5 = var1.method2703(!var4.method3053(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2716();
         } else if(var3 == 2) {
            var5.method2757();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2718(var4, var2);
         if(var3 == 1) {
            var5.rotateY90Ccw();
         } else if(var3 == 2) {
            var5.method2757();
         } else if(var3 == 3) {
            var5.method2716();
         }

         return var5;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lee;IB)Lee;",
      garbageValue = "9"
   )
   Model method5133(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class159.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2704(true);
      } else {
         Model var4 = var1.method2704(!var3.method3053(var2));
         var4.method2718(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lee;ILjo;IB)Lee;",
      garbageValue = "-81"
   )
   public Model method5134(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class159.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method5136(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class159.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2703(!var5.method3053(var2));
            var7.method2718(var5, var2);
            return var7;
         } else {
            var7 = var1.method2703(!var5.method3053(var2) & !var6.method3053(var4));
            var7.method2712(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lee;II)Lee;",
      garbageValue = "-943566819"
   )
   public Model method5153(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class159.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2703(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3678 != null && var2 < this.field3678.length) {
            var6 = this.field3678[var2];
            var5 = class159.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2703(!var4.method3053(var3) & !var5.method3053(var6));
            var7.method2718(var4, var3);
            var7.method2718(var5, var6);
            return var7;
         } else {
            var7 = var1.method2703(!var4.method3053(var3));
            var7.method2718(var4, var3);
            return var7;
         }
      }
   }
}
