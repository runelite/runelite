import java.io.File;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("ll")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   @Export("mouseWheel")
   static MouseWheel mouseWheel;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 696974527
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("n")
   @Export("objs")
   Object[] objs;
   @ObfuscatedName("v")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 549393119
   )
   int field795;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -972583329
   )
   int field793;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -601068453
   )
   int field798;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   Widget field797;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -624303511
   )
   int field800;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1142636893
   )
   int field801;
   @ObfuscatedName("f")
   @Export("string")
   String string;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1159253541
   )
   int field803;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   class230 field802;

   public ScriptEvent() {
      this.field802 = class230.field2908;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "-1530128191"
   )
   public void method1107(Object[] var1) {
      this.objs = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lhg;B)V",
      garbageValue = "14"
   )
   public void method1106(class230 var1) {
      this.field802 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "58512494"
   )
   static void method1108(File var0) {
      class160.field2181 = var0;
      if(!class160.field2181.exists()) {
         throw new RuntimeException("");
      } else {
         class160.field2179 = true;
      }
   }

   @ObfuscatedName("n")
   public static String method1112(long var0) {
      class193.field2567.setTime(new Date(var0));
      int var2 = class193.field2567.get(7);
      int var3 = class193.field2567.get(5);
      int var4 = class193.field2567.get(2);
      int var5 = class193.field2567.get(1);
      int var6 = class193.field2567.get(11);
      int var7 = class193.field2567.get(12);
      int var8 = class193.field2567.get(13);
      return class193.field2569[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class193.field2568[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1545744863"
   )
   static final void method1110() {
      short var0 = 256;
      int var1;
      if(class91.field1346 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1346 > 768) {
               class39.field515[var1] = class19.method149(Friend.field777[var1], GrandExchangeOffer.field296[var1], 1024 - class91.field1346);
            } else if(class91.field1346 > 256) {
               class39.field515[var1] = GrandExchangeOffer.field296[var1];
            } else {
               class39.field515[var1] = class19.method149(GrandExchangeOffer.field296[var1], Friend.field777[var1], 256 - class91.field1346);
            }
         }
      } else if(class91.field1350 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1350 > 768) {
               class39.field515[var1] = class19.method149(Friend.field777[var1], class33.field451[var1], 1024 - class91.field1350);
            } else if(class91.field1350 > 256) {
               class39.field515[var1] = class33.field451[var1];
            } else {
               class39.field515[var1] = class19.method149(class33.field451[var1], Friend.field777[var1], 256 - class91.field1350);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class39.field515[var1] = Friend.field777[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class91.field1336, 9, class91.field1336 + 128, var0 + 7);
      class91.field1339.method5287(class91.field1336, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class35.rasterProvider.width * 9 + class91.field1336;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1352[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = GrandExchangeEvent.field282[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class39.field515[var7];
               var10 = class35.rasterProvider.pixels[var2];
               class35.rasterProvider.pixels[var2++] = ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) + (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class35.rasterProvider.width - 128;
      }

      Rasterizer2D.setDrawRegion(class91.field1336 + 765 - 128, 9, class91.field1336 + 765, var0 + 7);
      GrandExchangeEvents.field269.method5287(class91.field1336 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class35.rasterProvider.width * 9 + class91.field1336 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1352[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = GrandExchangeEvent.field282[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class39.field515[var7];
               var10 = class35.rasterProvider.pixels[var2];
               class35.rasterProvider.pixels[var2++] = ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) + (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class35.rasterProvider.width - var5 - var4;
      }

   }
}
