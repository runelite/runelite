import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("l")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1788444141
   )
   @Export("length")
   int length;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "-1103296180"
   )
   MessageNode method974(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method2497();
         var5.method216(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "687391907"
   )
   MessageNode method975(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1936736225"
   )
   int method976() {
      return this.length;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "1"
   )
   public static boolean method982(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "2080180561"
   )
   static boolean method983(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class9.method122(var0, Client.field286);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class9.method122(Client.friends[var3].name, Client.field286)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class9.method122(class9.localPlayer.name, Client.field286))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("st")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZI)V",
      garbageValue = "2134977693"
   )
   protected static final void method986(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class0.canvas.getGraphics();
         if(null == GameObject.field1622) {
            GameObject.field1622 = new java.awt.Font("Helvetica", 1, 13);
            class49.field944 = class0.canvas.getFontMetrics(GameObject.field1622);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class2.field21, class20.field216);
         }

         if(null == var2) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(null == class22.field233) {
               class22.field233 = class0.canvas.createImage(304, 34);
            }

            Graphics var5 = class22.field233.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, var0 * 3, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + 3 * var0, 2, 300 - 3 * var0, 30);
            var5.setFont(GameObject.field1622);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - class49.field944.stringWidth(var1)) / 2, 22);
            var4.drawImage(class22.field233, class2.field21 / 2 - 152, class20.field216 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class2.field21 / 2 - 152;
            int var7 = class20.field216 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(2 + var6, 2 + var7, var0 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var6 + 1, 1 + var7, 301, 31);
            var4.fillRect(var0 * 3 + 2 + var6, var7 + 2, 300 - var0 * 3, 30);
            var4.setFont(GameObject.field1622);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - class49.field944.stringWidth(var1)) / 2, var7 + 22);
         }
      } catch (Exception var9) {
         class0.canvas.repaint();
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "-795439406"
   )
   static void method987(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = XClanMember.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field635 = 0;
            var0.actionAnimationDisable = var2;
            var0.field637 = 0;
         }

         if(var3 == 2) {
            var0.field637 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || XClanMember.getAnimation(var1).forcedPriority >= XClanMember.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field635 = 0;
         var0.actionAnimationDisable = var2;
         var0.field637 = 0;
         var0.field660 = var0.field655;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "-1671617150"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3006.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3037.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method3804(new Buffer(var2));
         }

         var1.method3803();
         NPCComposition.field3006.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)Ljava/lang/String;",
      garbageValue = "29"
   )
   static String method991(Buffer var0, int var1) {
      try {
         int var2 = var0.method2991();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class210.field3120.method2777(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class187.method3514(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
