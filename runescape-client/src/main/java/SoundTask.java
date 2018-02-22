import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("objects_ref")
   public static IndexDataBase objects_ref;
   @ObfuscatedName("a")
   @Export("IndexStoreActionHandler_thread")
   static Thread IndexStoreActionHandler_thread;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Ldw;"
   )
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2203();
            }
         }
      } catch (Exception var4) {
         class37.method519((String)null, var4);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;Lie;B)V",
      garbageValue = "-30"
   )
   public static void method2273(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.NpcDefinition_indexCache = var0;
      class159.NpcDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-286646283"
   )
   public static void method2271() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field569 = KeyFocusListener.field582;
         KeyFocusListener.field593 = 0;
         int var1;
         if(KeyFocusListener.field584 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.keyPressed[var1] = false;
            }

            KeyFocusListener.field584 = KeyFocusListener.field581;
         } else {
            while(KeyFocusListener.field584 != KeyFocusListener.field581) {
               var1 = KeyFocusListener.field580[KeyFocusListener.field581];
               KeyFocusListener.field581 = KeyFocusListener.field581 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.keyPressed[~var1] = false;
               } else {
                  if(!KeyFocusListener.keyPressed[var1] && KeyFocusListener.field593 < KeyFocusListener.field585.length - 1) {
                     KeyFocusListener.field585[++KeyFocusListener.field593 - 1] = var1;
                  }

                  KeyFocusListener.keyPressed[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field593 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field582 = KeyFocusListener.field588;
      }
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1410472875"
   )
   static void method2272() {
      if(BoundingBox3D.renderOverview != null) {
         BoundingBox3D.renderOverview.method5972(class230.plane, (OwnWorldComparator.localPlayer.x >> 7) + ScriptState.baseX, (OwnWorldComparator.localPlayer.y >> 7) + WorldMapType1.baseY, false);
         BoundingBox3D.renderOverview.method5986();
      }

   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1442781025"
   )
   static final void method2269(int var0) {
      int[] var1 = class131.minimapSprite.pixels;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
               GameObject.region.method2917(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               GameObject.region.method2917(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class131.minimapSprite.method5802();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
               class39.method551(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class39.method551(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1030 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = GameObject.region.method2912(class230.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = Preferences.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.mapIcons[Client.field1030] = class330.mapAreaType[var8].getMapIcon(false);
                  Client.field850[Client.field1030] = var5;
                  Client.field1037[Client.field1030] = var6;
                  ++Client.field1030;
               }
            }
         }
      }

      class324.rasterProvider.setRaster();
   }
}
