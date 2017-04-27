import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -519687951
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("c")
   static IndexDataBase field3085;
   @ObfuscatedName("n")
   static IndexDataBase field3086;
   @ObfuscatedName("q")
   static NodeCache field3087 = new NodeCache(64);
   @ObfuscatedName("t")
   static NodeCache field3088 = new NodeCache(100);
   @ObfuscatedName("g")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("u")
   int[] field3090;
   @ObfuscatedName("z")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("p")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -931800789
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("w")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("l")
   public int[] field3095;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -962377335
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 49393981
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("d")
   static IndexDataBase field3098;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1456214883
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1385195869
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -691365987
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1623667613
   )
   @Export("replyMode")
   public int replyMode = 2;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1776320694"
   )
   void method3859(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3860(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1891319941"
   )
   void method3860(Buffer var1, int var2) {
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
         this.field3090 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3090[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3090[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3095 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3095[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-30"
   )
   public Model method3862(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class137.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1571(true);
      } else {
         Model var4 = var1.method1571(!var3.method1910(var2));
         var4.method1577(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "2003143953"
   )
   Model method3864(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class137.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1572(true);
      } else {
         Model var4 = var1.method1572(!var3.method1910(var2));
         var4.method1577(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1574796496"
   )
   public Model method3865(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class137.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method1571(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3090 != null && var2 < this.field3090.length) {
            var6 = this.field3090[var2];
            var5 = class137.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method1571(!var4.method1910(var3) & !var5.method1910(var6));
            var7.method1577(var4, var3);
            var7.method1577(var5, var6);
            return var7;
         } else {
            var7 = var1.method1571(!var4.method1910(var3));
            var7.method1577(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2120203054"
   )
   void method3867() {
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IB)LModel;",
      garbageValue = "22"
   )
   public Model method3875(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class137.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method3862(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class137.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method1571(!var5.method1910(var2));
            var7.method1577(var5, var2);
            return var7;
         } else {
            var7 = var1.method1571(!var5.method1910(var2) & !var6.method1910(var4));
            var7.method1578(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "1821020792"
   )
   Model method3879(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class137.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method1571(true);
      } else {
         Model var5 = var1.method1571(!var4.method1910(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1580();
         } else if(var3 == 2) {
            var5.method1593();
         } else if(var3 == 3) {
            var5.method1598();
         }

         var5.method1577(var4, var2);
         if(var3 == 1) {
            var5.method1598();
         } else if(var3 == 2) {
            var5.method1593();
         } else if(var3 == 3) {
            var5.method1580();
         }

         return var5;
      }
   }
}
