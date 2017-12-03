import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("identKit_ref")
   public static IndexDataBase identKit_ref;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   public static IndexDataBase field3432;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("identKits")
   static NodeCache identKits;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 755102505
   )
   @Export("bodyPartId")
   public int bodyPartId;
   @ObfuscatedName("z")
   @Export("modelIds")
   int[] modelIds;
   @ObfuscatedName("t")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("f")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("g")
   @Export("retextureToFind")
   short[] retextureToFind;
   @ObfuscatedName("j")
   @Export("retextureToReplace")
   short[] retextureToReplace;
   @ObfuscatedName("x")
   @Export("models")
   int[] models;
   @ObfuscatedName("c")
   @Export("nonSelectable")
   public boolean nonSelectable;

   static {
      identKits = new NodeCache(64);
   }

   KitDefinition() {
      this.bodyPartId = -1;
      this.models = new int[]{-1, -1, -1, -1, -1};
      this.nonSelectable = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "-1440292873"
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
      garbageValue = "-48866869"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.bodyPartId = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.modelIds = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.modelIds[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.nonSelectable = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorToFind = new short[var3];
            this.recolorToReplace = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorToFind[var4] = (short)var1.readUnsignedShort();
               this.recolorToReplace[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retextureToFind = new short[var3];
            this.retextureToReplace = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureToFind[var4] = (short)var1.readUnsignedShort();
               this.retextureToReplace[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.models[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "783096153"
   )
   @Export("ready")
   public boolean ready() {
      if(this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            if(!field3432.tryLoadRecord(this.modelIds[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Ldm;",
      garbageValue = "124"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.modelIds == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.modelIds.length];

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1[var2] = ModelData.method2428(field3432, this.modelIds[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.recolorToFind != null) {
            for(var3 = 0; var3 < this.recolorToFind.length; ++var3) {
               var4.recolor(this.recolorToFind[var3], this.recolorToReplace[var3]);
            }
         }

         if(this.retextureToFind != null) {
            for(var3 = 0; var3 < this.retextureToFind.length; ++var3) {
               var4.method2437(this.retextureToFind[var3], this.retextureToReplace[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-3"
   )
   public boolean method4514() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !field3432.tryLoadRecord(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ldm;",
      garbageValue = "-338038521"
   )
   public ModelData method4511() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.models[var3] != -1) {
            var1[var2++] = ModelData.method2428(field3432, this.models[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.recolorToFind != null) {
         for(var4 = 0; var4 < this.recolorToFind.length; ++var4) {
            var5.recolor(this.recolorToFind[var4], this.recolorToReplace[var4]);
         }
      }

      if(this.retextureToFind != null) {
         for(var4 = 0; var4 < this.retextureToFind.length; ++var4) {
            var5.method2437(this.retextureToFind[var4], this.retextureToReplace[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljq;",
      garbageValue = "946787480"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4711(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4712(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.int3 != -1) {
            var1.method4753(getItemDefinition(var1.int3), getItemDefinition(var1.int2));
         }

         if(!ScriptState.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.int1 = 0;
            if(var1.field3607 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3607.getHead(); var4 != null; var4 = var1.field3607.getTail()) {
                  class262 var5 = VarPlayerType.method4426((int)var4.hash);
                  if(var5.field3465) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3607 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }
}
