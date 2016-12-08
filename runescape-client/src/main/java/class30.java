import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class30 {
   @ObfuscatedName("b")
   boolean field699;
   @ObfuscatedName("g")
   boolean field700;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -15113315
   )
   int field701 = 1;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 1625508667
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 486350755
   )
   static int field705 = 4;
   @ObfuscatedName("v")
   LinkedHashMap field706 = new LinkedHashMap();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)LBuffer;",
      garbageValue = "111"
   )
   Buffer method633() {
      Buffer var1 = new Buffer(100);
      var1.method2815(field705);
      var1.method2815(this.field699?1:0);
      var1.method2815(this.field700?1:0);
      var1.method2815(this.field701);
      var1.method2815(this.field706.size());
      Iterator var2 = this.field706.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2714(((Integer)var3.getKey()).intValue());
         var1.method2714(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "850542215"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field2995.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3014.method3203(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(null != var2) {
            var1.method3632(new Buffer(var2));
         }

         var1.method3617();
         NPCComposition.field2995.put(var1, (long)var0);
         return var1;
      }
   }

   class30() {
      this.method643(true);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1097163441"
   )
   void method643(boolean var1) {
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIB)V",
      garbageValue = "100"
   )
   static void method645(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class31.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field639 = 0;
            var0.actionAnimationDisable = var2;
            var0.field626 = 0;
         }

         if(var3 == 2) {
            var0.field626 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class31.getAnimation(var1).forcedPriority >= class31.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field639 = 0;
         var0.actionAnimationDisable = var2;
         var0.field626 = 0;
         var0.field663 = var0.field656;
      }

   }

   class30(Buffer var1) {
      if(null != var1 && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field705) {
            if(var1.readUnsignedByte() == 1) {
               this.field699 = true;
            }

            if(var2 > 1) {
               this.field700 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field701 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2731();
                  int var6 = var1.method2731();
                  this.field706.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method643(true);
         }
      } else {
         this.method643(true);
      }

   }
}
