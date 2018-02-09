import java.awt.Component;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 101153337
   )
   static int field1198;
   @ObfuscatedName("m")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("h")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1494594889
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("w")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("t")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("d")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1198 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1679(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgy;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1198) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.rememberedUsername = var1.getNullString();
            }

            if(var2 > 5) {
               this.hideUsername = var1.method3515();
            }
         } else {
            this.method1679(true);
         }
      } else {
         this.method1679(true);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2131025764"
   )
   void method1679(boolean var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Lgy;",
      garbageValue = "55"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1198);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      var1.putString(this.rememberedUsername != null?this.rememberedUsername:"");
      var1.writeBooleanAsByte(this.hideUsername);
      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "7099"
   )
   static void method1678(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-541973365"
   )
   static final void method1667(String var0) {
      PacketNode var1 = Script.method2025(ClientPacket.field2406, Client.field937.field1454);
      var1.packetBuffer.putByte(FrameMap.getLength(var0));
      var1.packetBuffer.putString(var0);
      Client.field937.method2044(var1);
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(Lbe;I)V",
      garbageValue = "-2051518779"
   )
   static final void method1666(Actor var0) {
      var0.field1117 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = FileRequest.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1145;
            if(var0.poseFrame < var1.frameIDs.length && var0.field1145 > var1.frameLenghts[var0.poseFrame]) {
               var0.field1145 = 1;
               ++var0.poseFrame;
               ScriptVarType.queueAnimationSound(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field1145 = 0;
               var0.poseFrame = 0;
               ScriptVarType.queueAnimationSound(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1152 < 0) {
            var0.field1152 = 0;
         }

         int var3 = CollisionData.getSpotAnimType(var0.graphic).field3404;
         if(var3 != -1) {
            Sequence var2 = FileRequest.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.field1153;
               if(var0.field1152 < var2.frameIDs.length && var0.field1153 > var2.frameLenghts[var0.field1152]) {
                  var0.field1153 = 1;
                  ++var0.field1152;
                  ScriptVarType.queueAnimationSound(var2, var0.field1152, var0.x, var0.y);
               }

               if(var0.field1152 >= var2.frameIDs.length && (var0.field1152 < 0 || var0.field1152 >= var2.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var1 = FileRequest.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field1161 > 0 && var0.field1160 <= Client.gameCycle && var0.field1149 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = FileRequest.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1140;
            if(var0.actionFrame < var1.frameIDs.length && var0.field1140 > var1.frameLenghts[var0.actionFrame]) {
               var0.field1140 = 1;
               ++var0.actionFrame;
               ScriptVarType.queueAnimationSound(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field1150;
               if(var0.field1150 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  ScriptVarType.queueAnimationSound(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1117 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "559819191"
   )
   static final String method1680(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
