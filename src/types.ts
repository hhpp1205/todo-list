export type Todo = {
    id: number;
    text: string;
    checked: boolean;
};

export type ModalType = "deleteAll" | "deleteOne" | null;