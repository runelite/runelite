import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("GameCanvas")
public final class GameCanvas extends Canvas {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = 995527087
   )
   static int field628;
   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("n")
   @Export("component")
   Component component;

   GameCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lil;III)Lkg;",
      garbageValue = "-1997700749"
   )
   public static SpritePixels method772(IndexDataBase var0, int var1, int var2) {
      return !class288.method5126(var0, var1, var2)?null:class31.method270();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-881545333"
   )
   public static void method774() {
      KitDefinition.identKits.reset();
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1555558158"
   )
   static final void method778() {
      int var0 = SoundTaskDataProvider.field624 * 128 + 64;
      int var1 = ChatLineBuffer.field1456 * 128 + 64;
      int var2 = MouseInput.getTileHeight(var0, var1, class7.plane) - Friend.field782;
      if(GameEngine.cameraX < var0) {
         GameEngine.cameraX = (var0 - GameEngine.cameraX) * class20.field327 / 1000 + GameEngine.cameraX + class82.field1272;
         if(GameEngine.cameraX > var0) {
            GameEngine.cameraX = var0;
         }
      }

      if(GameEngine.cameraX > var0) {
         GameEngine.cameraX -= class20.field327 * (GameEngine.cameraX - var0) / 1000 + class82.field1272;
         if(GameEngine.cameraX < var0) {
            GameEngine.cameraX = var0;
         }
      }

      if(ScriptEvent.cameraZ < var2) {
         ScriptEvent.cameraZ = (var2 - ScriptEvent.cameraZ) * class20.field327 / 1000 + ScriptEvent.cameraZ + class82.field1272;
         if(ScriptEvent.cameraZ > var2) {
            ScriptEvent.cameraZ = var2;
         }
      }

      if(ScriptEvent.cameraZ > var2) {
         ScriptEvent.cameraZ -= class20.field327 * (ScriptEvent.cameraZ - var2) / 1000 + class82.field1272;
         if(ScriptEvent.cameraZ < var2) {
            ScriptEvent.cameraZ = var2;
         }
      }

      if(MouseInput.cameraY < var1) {
         MouseInput.cameraY = (var1 - MouseInput.cameraY) * class20.field327 / 1000 + MouseInput.cameraY + class82.field1272;
         if(MouseInput.cameraY > var1) {
            MouseInput.cameraY = var1;
         }
      }

      if(MouseInput.cameraY > var1) {
         MouseInput.cameraY -= class20.field327 * (MouseInput.cameraY - var1) / 1000 + class82.field1272;
         if(MouseInput.cameraY < var1) {
            MouseInput.cameraY = var1;
         }
      }

      var0 = WorldMapType3.field377 * 128 + 64;
      var1 = ClanMember.field871 * 128 + 64;
      var2 = MouseInput.getTileHeight(var0, var1, class7.plane) - FriendLoginUpdate.field786;
      int var3 = var0 - GameEngine.cameraX;
      int var4 = var2 - ScriptEvent.cameraZ;
      int var5 = var1 - MouseInput.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(SoundTask.cameraPitch < var7) {
         SoundTask.cameraPitch = (var7 - SoundTask.cameraPitch) * field628 / 1000 + SoundTask.cameraPitch + Timer.field2191;
         if(SoundTask.cameraPitch > var7) {
            SoundTask.cameraPitch = var7;
         }
      }

      if(SoundTask.cameraPitch > var7) {
         SoundTask.cameraPitch -= field628 * (SoundTask.cameraPitch - var7) / 1000 + Timer.field2191;
         if(SoundTask.cameraPitch < var7) {
            SoundTask.cameraPitch = var7;
         }
      }

      int var9 = var8 - class2.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class2.cameraYaw = var9 * field628 / 1000 + class2.cameraYaw + Timer.field2191;
         class2.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class2.cameraYaw -= -var9 * field628 / 1000 + Timer.field2191;
         class2.cameraYaw &= 2047;
      }

      int var10 = var8 - class2.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class2.cameraYaw = var8;
      }

   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1202181042"
   )
   static void method779() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.menuBooleanArray[var3] = Client.menuBooleanArray[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
