import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("z")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("t")
   int[] field3674;
   @ObfuscatedName("f")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("g")
   public int[] field3676;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -220100085
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("x")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("c")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1623144549
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 199012451
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1249525367
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -502401333
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -235496103
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 100974965
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1611211339
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "1579517759"
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "-1551557110"
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
         this.field3674 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3674[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3674[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3676 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3676[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-85066389"
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lef;II)Lef;",
      garbageValue = "830412713"
   )
   public Model method4837(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = GraphicsObject.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2509(true);
      } else {
         Model var4 = var1.method2509(!var3.method2884(var2));
         var4.method2517(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lef;III)Lef;",
      garbageValue = "-1474656173"
   )
   Model method4838(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = GraphicsObject.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2509(true);
      } else {
         Model var5 = var1.method2509(!var4.method2884(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2522();
         } else if(var3 == 2) {
            var5.method2521();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2517(var4, var2);
         if(var3 == 1) {
            var5.rotateY90Ccw();
         } else if(var3 == 2) {
            var5.method2521();
         } else if(var3 == 3) {
            var5.method2522();
         }

         return var5;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lef;II)Lef;",
      garbageValue = "-2039031586"
   )
   Model method4839(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = GraphicsObject.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2555(true);
      } else {
         Model var4 = var1.method2555(!var3.method2884(var2));
         var4.method2517(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lef;ILjj;II)Lef;",
      garbageValue = "352533500"
   )
   public Model method4847(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = GraphicsObject.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method4837(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = GraphicsObject.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2509(!var5.method2884(var2));
            var7.method2517(var5, var2);
            return var7;
         } else {
            var7 = var1.method2509(!var5.method2884(var2) & !var6.method2884(var4));
            var7.method2588(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lef;II)Lef;",
      garbageValue = "779613545"
   )
   public Model method4856(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = GraphicsObject.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2509(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3674 != null && var2 < this.field3674.length) {
            var6 = this.field3674[var2];
            var5 = GraphicsObject.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2509(!var4.method2884(var3) & !var5.method2884(var6));
            var7.method2517(var4, var3);
            var7.method2517(var5, var6);
            return var7;
         } else {
            var7 = var1.method2509(!var4.method2884(var3));
            var7.method2517(var4, var3);
            return var7;
         }
      }
   }
}
